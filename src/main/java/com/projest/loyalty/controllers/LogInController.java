package com.projest.loyalty.controllers;

import com.projest.loyalty.dao.CustomerDAO;
import com.projest.loyalty.dao.OfferDAO;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.Customer;
import com.projest.loyalty.entity.Offer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LogInController {

    private List<Offer> availOffers = new ArrayList<>();
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
        OfferDAO offerDAO = new OfferDAO(DBService.getMysqlConnection());
        availOffers = offerDAO.getOffers();
        session.setAttribute("username", customer.getFirstName());
        model.addAttribute("customerFirstName", customer.getFirstName());
        model.addAttribute("customer", customer);
        model.addAttribute("availOffers", availOffers);
        return "customerView";
    }
}
