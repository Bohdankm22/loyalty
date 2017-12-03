package com.projest.loyalty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class OfferCreatedController {
    @RequestMapping(value = "/offerCreated", method = RequestMethod.POST)
    public String submit(@RequestParam("discount") String discount, @RequestParam("cost") String cost,
                         @RequestParam("id") String id, Model model, HttpSession session) {

        return "offers";
    }
}
