package com.projest.loyalty.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class AboutController {

    // inject via application.properties
    @Value("${about.message}")
    private String message = "";

    @RequestMapping("/about")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "about";
    }
}
