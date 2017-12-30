package com.projest.loyalty.controllers;

import com.projest.loyalty.entity.User;
import com.projest.loyalty.entity.UserRole;
import com.projest.loyalty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class APIUsersController {

    private final UserRepository userRepository;

    @Autowired
    public APIUsersController(UserRepository userRepository) {
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

    @RequestMapping(path = "/user/", method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") long id) {
        return userRepository.findOne(id);
    }
}
