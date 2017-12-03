package com.projest.loyalty.controllers;

import com.projest.loyalty.dao.LoyaltyProgramDAO;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.LoyaltyProgram;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoyaltyProgramsController {
    private static final Logger logger = Logger.getLogger(LoyaltyProgramsController.class);

    private LoyaltyProgram loyaltyProgram;
    private String programName;
    private String companyName;

    @RequestMapping(value = "/loyaltyProgram")
    public String welcome(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        // TODO Remove hardcode
        loyaltyProgram = new LoyaltyProgramDAO(DBService.getMysqlConnection()).get(1);
        programName = loyaltyProgram.getName();
        companyName = loyaltyProgram.getCompany().getName();
        model.addAttribute("programName", programName);
        model.addAttribute("companyName", companyName);
        return "loyaltyProgram";
    }

}

