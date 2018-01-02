package com.projest.loyalty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String welcome(HttpSession session) {
        session.invalidate();
        return "welcome";
    }
}
