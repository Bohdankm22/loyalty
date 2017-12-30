package com.projest.loyalty.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.projest.loyalty.entity.Task;
import com.projest.loyalty.entity.User;
import com.projest.loyalty.entity.UserRole;
import com.projest.loyalty.entity.view.Views;
import com.projest.loyalty.repository.TaskRepository;
import com.projest.loyalty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class APIUsersController {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public APIUsersController(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
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

    /**
     * API call to retreive all the users.
     * @return JSON with all users.
     */
    @JsonView(Views.Users.class)
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * API call to retreive specific user with his id.
     * @param id user identification number.
     * @return JSON with user details.
     */
    @JsonView(Views.User.class)
    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") long id) {
        return userRepository.findOne(id);
    }

    @JsonView(Views.UserTask.class)
    @RequestMapping(path = "/user/{id}/task", method = RequestMethod.GET)
    public User getUserTasks(@PathVariable("id") long id) {
        return userRepository.findOne(id);
    }

    /**
     * API call to retreive all the tasks.
     * @return JSON with all tasks.
     */
    @JsonView(Views.Tasks.class)
    @RequestMapping(path = "/task", method = RequestMethod.GET)
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * API call to retreive specific task with its id.
     * @param id task identification number.
     * @return JSON with task details.
     */
    @JsonView(Views.Task.class)
    @RequestMapping(path = "/task/{id}", method = RequestMethod.GET)
    public Task getTask(@PathVariable("id") long id) {
        return taskRepository.findOne(id);
    }
}
