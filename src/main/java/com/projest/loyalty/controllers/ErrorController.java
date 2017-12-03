package com.projest.loyalty.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController {

    @RequestMapping("/error")
    public String error() {
        return "error";
    }
}
