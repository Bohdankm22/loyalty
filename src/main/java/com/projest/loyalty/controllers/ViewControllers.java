package com.projest.loyalty.controllers;

import com.projest.loyalty.entity.User;
import com.projest.loyalty.entity.UserRole;
import com.projest.loyalty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ViewControllers {

    private final UserRepository userRepository;

    @Autowired
    public ViewControllers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/managerview")
    public String managv(Map<String, Object> model, HttpSession session) {
        model.put("employees", userRepository.findByRole(UserRole.EMPLOYEE.ordinal()));
        return "managerview";
    }

    @RequestMapping(value = "/adminview")
    public String adminv(Map<String, Object> model, HttpSession session, HttpServletRequest request) {
        model.put("users", userRepository.findAll());
        return "adminview";
    }

    @RequestMapping(value = "/employeeview")
    public String empv(Map<String, Object> model, HttpSession session, HttpServletRequest request) {
        long userid = (long) session.getAttribute("user");
        User user = userRepository.findOne(userid);
        model.put("tasks", user.getTasks());
        return "employeeview";
    }

    @RequestMapping(value = "/hrview")
    public String hrv(Map<String, Object> model, HttpSession session, HttpServletRequest request) {
        model.put("employees", userRepository.findAll());
        return "hrview";
    }

    @RequestMapping(value = "/accountantview")
    public String accv(Map<String, Object> model, HttpSession session, HttpServletRequest request) {
        model.put("emp", userRepository.findAll());
        return "accountantview";
    }
}
