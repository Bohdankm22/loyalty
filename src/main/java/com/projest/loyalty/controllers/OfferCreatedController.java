package com.projest.loyalty.controllers;

import com.intuit.ipp.data.Item;
import com.projest.loyalty.appinfo.ManagerInfo;
import com.projest.loyalty.dao.CompanyDAO;
import com.projest.loyalty.dao.LoyaltyProgramDAO;
import com.projest.loyalty.dao.OfferDAO;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.Company;
import com.projest.loyalty.entity.LoyaltyProgram;
import com.projest.loyalty.entity.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OfferCreatedController {

    @Autowired
    org.springframework.core.env.Environment env;
    private LoyaltyProgram loyaltyProgram;
    private String programName;
    private String companyName;
    private List<Offer> availOffers = new ArrayList<>();
    private List<Item> goods;

    @RequestMapping(value = "/offerCreated", method = RequestMethod.POST)
    public String submit(@RequestParam("discount") Long discount, @RequestParam("cost") Long cost,
                         @RequestParam("id") String id, Model model, HttpSession session) {
        Item item = ManagerInfo.getInstance().getGoodById(id);
        Offer offer = new Offer(Long.parseLong(item.getId()), item.getName(), item.getDescription(), item.getType().toString(),
                discount, cost);
        OfferDAO offerDAO = new OfferDAO(DBService.getMysqlConnection());
        offerDAO.insertOffer(offer);

        Long managerId = (Long) session.getAttribute(env.getProperty("manager.id"));
        Company company = new CompanyDAO(DBService.getMysqlConnection()).getCompanyByManagerId(managerId);
        loyaltyProgram = new LoyaltyProgramDAO(DBService.getMysqlConnection()).getLoyaltyByCompany(company);
        programName = loyaltyProgram.getName();
        companyName = loyaltyProgram.getCompany().getName();
        offerDAO = new OfferDAO(DBService.getMysqlConnection());
        availOffers = offerDAO.getOffers();
        model.addAttribute("programName", programName);
        model.addAttribute("companyName", companyName);
        model.addAttribute("availOffers", availOffers);
        model.addAttribute("goods", ManagerInfo.getInstance().getGoods());
        model.addAttribute("availOffers", availOffers);
        return "offers";
    }
}
