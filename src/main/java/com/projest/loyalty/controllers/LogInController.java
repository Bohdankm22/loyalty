package com.projest.loyalty.controllers;

import com.projest.loyalty.entity.User;
import com.projest.loyalty.entity.UserRole;
import com.projest.loyalty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LogInController {

    private final UserRepository userRepository;

    @Autowired
    public LogInController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String submit(@RequestParam("login") String login, @RequestParam("password") String password,
                         Map<String, Object> model) {
        User user = userRepository.findByLoginPassword(login, password);
        if (user == null) {
            return "/error";
        }
        String result = "/error";
        model.put("login", user.getName() + " " + user.getSurname());
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
                break;
            case ACCOUNTANT:
                model.put("emp", userRepository.findAll());
                result = "accountantview";
                break;
        }
        return result;
    }
}
