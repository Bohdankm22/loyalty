package com.projest.loyalty.controllers;

import com.projest.loyalty.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ManagerController {

    private final TaskRepository taskRepository;

    @Autowired
    public ManagerController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping(value = "/viewtasks", method = RequestMethod.GET)
    public String submit(Map<String, Object> model) {
        model.put("tasks", taskRepository.findAll());
        return "managerviewtasks";
    }
}
