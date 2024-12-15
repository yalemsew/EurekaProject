package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/getUserOrders/{userId}")
    public String getUserOrders(@PathVariable String userId) {
        // Discover user-service dynamically
        String userServiceUrl = "http://user-service/users/" + userId;

        // Call user-service
        String user = restTemplate.getForObject(userServiceUrl, String.class);
        return "Orders for: " + user;
    }
    @GetMapping("/")
    public String home() {
        return "Welcome to User Service!";
    }
}

//@RestController
//@RequestMapping("/orders")
//public class OrderController {
//    @Autowired
//    private RestTemplate restTemplate;
//    @GetMapping("/getUserOrders/{userId}")
//    public String getUserOrders(@PathVariable String userId) {
//        // Replace service ID with hardcoded IP and port
//        String userServiceUrl = "http://192.168.0.13:8081/users/" + userId;
//
//        // Call the user-service directly
//        String user = restTemplate.getForObject(userServiceUrl, String.class);
//        return "Orders for user without Eureka1: " + user;
//    }
//}


