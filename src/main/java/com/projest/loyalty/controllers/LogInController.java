package com.projest.loyalty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LogInController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginCustomer", method = RequestMethod.POST)
    public String submit(@RequestParam("login") String login, @RequestParam("password") String password, Model model, HttpSession session) {
        /*if (customer == null) {
            return "/error";
        }*/


        return "customerView";
    }
}
