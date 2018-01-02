package com.projest.loyalty.controllers;

import com.projest.loyalty.auth.service.SecurityService;
import com.projest.loyalty.auth.validator.UserValidator;
import com.projest.loyalty.entity.User;
import com.projest.loyalty.entity.UserRole;
import com.projest.loyalty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LogInController {

    private final UserRepository userRepository;
    private final SecurityService securityService;
    private final UserValidator userValidator;

    @Autowired
    public LogInController(UserRepository userRepository, SecurityService securityService, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String submit(@RequestParam("login") String login, @RequestParam("password") String password,
                         Map<String, Object> model, HttpSession session) {

        securityService.autologin(login, password);
        if (!securityService.findLoggedInUsername().equals(login)) {
            return "/error";
        }
        User user = userRepository.findByLogin(login);
        String result = "/error";
        session.setAttribute("user", user.getId());

        model.put("username", user);
        session.setAttribute("login", user.getName() + " " + user.getSurname());
        switch (user.getUserRole()) {
            case HR:
                result = "hrview";
                break;
            case ADMIN:
                model.put("users", userRepository.findAll());
                result = "adminview";
                break;
            case MANAGER:
                model.put("employees", userRepository.findByRole(UserRole.EMPLOYEE.ordinal()));
                result = "managerview";
                break;
            case EMPLOYEE:
                result = "employeeview";
                model.put("tasks", user.getTasks());
                break;
            case ACCOUNTANT:
                model.put("emp", userRepository.findAll());
                result = "accountantview";
                break;
        }
        return result;
    }
}
