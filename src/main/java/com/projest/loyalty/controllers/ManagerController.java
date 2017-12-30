package com.projest.loyalty.controllers;

import com.projest.loyalty.entity.User;
import com.projest.loyalty.entity.UserRole;
import com.projest.loyalty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ManagerController {

    private final UserRepository userRepository;

    @Autowired
    public ManagerController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/viewtasks", method = RequestMethod.GET)
    public String submit(Map<String, Object> model) {
        return "managerviewtasks";
    }
}
