package com.projest.loyalty.controllers;

import com.projest.loyalty.entity.User;
import com.projest.loyalty.entity.UserRole;
import com.projest.loyalty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UsersController {

    private final UserRepository userRepository;

    @Autowired
    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam(name = "login") String login,
                      @RequestParam(name = "password") String password,
                      @RequestParam(name = "role") String role,
                      @RequestParam(name = "name", required = false) String name,
                      @RequestParam(name = "surname", required = false) String surname) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        User user = new User.UserBuilder(login, password,
                UserRole.getUserRole(role)).setName(name).setSurname(surname).build();
        userRepository.save(user);
        return String.format("Saved user %s", user);
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
