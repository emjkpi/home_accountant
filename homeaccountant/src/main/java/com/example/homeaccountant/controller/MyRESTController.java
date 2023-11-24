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
}
