package com.example.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{userId}")
    public String getUser(@PathVariable String userId) {
        return "User with ID " + userId;
    }
    @GetMapping("")
    public String home() {
        return "Welcome to User Service!";
    }
}
