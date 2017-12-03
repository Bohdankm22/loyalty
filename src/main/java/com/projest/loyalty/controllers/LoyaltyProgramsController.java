package com.projest.loyalty.controllers;

import com.projest.loyalty.dao.LoyaltyProgramDAO;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.LoyaltyProgram;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoyaltyProgramsController {
    private static final Logger logger = Logger.getLogger(LoyaltyProgramsController.class);

    private LoyaltyProgram loyaltyProgram;

    @RequestMapping("/loyaltyPrograms")
    public String welcome() {
        loyaltyProgram = new LoyaltyProgramDAO(DBService.getMysqlConnection()).get(1);

        return "loyaltyPrograms";
    }
}

