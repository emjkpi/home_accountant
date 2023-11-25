package com.example.homeaccountant.controller;

import com.example.homeaccountant.entity.User;
import com.example.homeaccountant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private final Logger logger = LoggerFactory.getLogger(MyRESTController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        logger.info("Retrieved users: {}", allUsers);
        return allUsers;
    }

    @GetMapping("/users/{id}")
    public User user(@PathVariable int id) {
        User user = userService.getUser(id);

        return user;
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {

        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {

        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {

        userService.deleteUser(id);
        return "User with ID = " + id + " was deleted";
    }
}
