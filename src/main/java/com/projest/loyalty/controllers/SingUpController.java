package com.projest.loyalty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SingUpController {

    @RequestMapping("/addUser")
    public String signup() {
        return "singup";
    }

    // TODO Implement adding
    @RequestMapping(value = "/singUpCustomer", method = RequestMethod.POST)
    public String submit(@RequestParam("login") String login, @RequestParam("password") String password,
                         Map<String, Object> model) {
        return "adminview";
    }
}
