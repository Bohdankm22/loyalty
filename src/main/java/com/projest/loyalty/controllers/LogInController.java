package com.projest.loyalty.controllers;

import com.projest.loyalty.entity.User;
import com.projest.loyalty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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
    public String submit(@RequestParam("login") String login, @RequestParam("password") String password) {
        User user = userRepository.findByLoginPassword(login, password);
        String result = "/error";
        switch (user.getUserRole()) {
            case HR:
                result = "hrview";
                break;
            case ADMIN:
                result = "adminview";
                break;
            case MANAGER:
                result = "managerview";
                break;
            case EMPLOYEE:
                result = "employeeview";
                break;
            case ACCOUNTANT:
                result = "accountantview";
                break;
        }
        return result;
    }
}
