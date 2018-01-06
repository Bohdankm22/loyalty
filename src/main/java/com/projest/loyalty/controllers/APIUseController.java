package com.projest.loyalty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class APIUseController {

    @RequestMapping("/apiuse")
    public String welcome() {
        return "apiuse";
    }
}
