package com.projest.loyalty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SingUpController {

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }
}
