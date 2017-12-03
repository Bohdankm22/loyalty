package com.projest.loyalty.controllers;

import com.projest.loyalty.dao.CustomerDAO;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.Customer;
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
        Customer customer = new CustomerDAO(DBService.getMysqlConnection()).getCustomerByLogin(login, password);
        if (customer == null) {
            return "/error";
        }
        session.setAttribute("username", customer.getFirstName());
        model.addAttribute("customerFirstName", customer.getFirstName());
        model.addAttribute("customer", customer);
        return "customerView";
    }
}
