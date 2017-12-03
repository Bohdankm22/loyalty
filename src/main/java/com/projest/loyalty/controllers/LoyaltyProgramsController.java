package com.projest.loyalty.controllers;

import com.projest.loyalty.dao.CompanyDAO;
import com.projest.loyalty.dao.LoyaltyProgramDAO;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.Company;
import com.projest.loyalty.entity.LoyaltyProgram;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@PropertySource(value = "classpath:/application.properties", ignoreResourceNotFound = true)
public class LoyaltyProgramsController {
    private static final Logger logger = Logger.getLogger(LoyaltyProgramsController.class);

    @Autowired
    org.springframework.core.env.Environment env;
    private LoyaltyProgram loyaltyProgram;
    private String programName;
    private String companyName;

    @RequestMapping(value = "/loyaltyProgram")
    public String welcome(Model model, HttpSession session) {
        Long managerId = (Long) session.getAttribute(env.getProperty("manager.id"));
        Company company = new CompanyDAO(DBService.getMysqlConnection()).getCompanyByManagerId(managerId);
        loyaltyProgram = new LoyaltyProgramDAO(DBService.getMysqlConnection()).getLoyaltyByCompany(company);
        programName = loyaltyProgram.getName();
        companyName = loyaltyProgram.getCompany().getName();
        model.addAttribute("programName", programName);
        model.addAttribute("companyName", companyName);
        return "loyaltyProgram";
    }

}

