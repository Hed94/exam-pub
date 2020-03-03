package com.example.tavern.api;

import com.example.tavern.model.User;
import com.example.tavern.other.Views;
import com.example.tavern.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @JsonView(Views.UsersWithoutOrders.class)
    @GetMapping
    public List<User> getAllUsersWithoutOrders()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/1")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
}
