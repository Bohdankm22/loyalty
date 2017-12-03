package com.projest.loyalty.controllers;

import com.intuit.ipp.data.Item;
import com.projest.loyalty.appinfo.ManagerInfo;
import com.projest.loyalty.dao.OfferDAO;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.Offer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class OfferCreatedController {
    @RequestMapping(value = "/offerCreated", method = RequestMethod.POST)
    public String submit(@RequestParam("discount") Long discount, @RequestParam("cost") Long cost,
                         @RequestParam("id") String id, Model model, HttpSession session) {
        Item item = ManagerInfo.getInstance().getGoodById(id);
        Offer offer = new Offer(Long.parseLong(item.getId()), item.getName(), item.getDescription(), item.getType().toString(),
                discount, cost);
        OfferDAO offerDAO = new OfferDAO(DBService.getMysqlConnection());
        offerDAO.insertOffer(offer);
        return "offers";
    }
}
