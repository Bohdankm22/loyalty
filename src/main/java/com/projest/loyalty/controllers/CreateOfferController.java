package com.projest.loyalty.controllers;

import com.intuit.ipp.data.Item;
import com.projest.loyalty.appinfo.ManagerInfo;
import com.projest.loyalty.dao.CustomerDAO;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.Customer;
import com.projest.loyalty.queries.ItemQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CreateOfferController {

    @RequestMapping(value = "/createOffer", method = RequestMethod.POST)
    public String submit(Model model, HttpServletRequest httpServletRequest) {
        Item item = ManagerInfo.getInstance().getGoodById(httpServletRequest.getParameter("itemId"));
        model.addAttribute("item", item);
        return "createOffer";
    }
}
