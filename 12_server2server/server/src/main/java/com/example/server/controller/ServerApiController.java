package com.example.server.controller;

import com.example.server.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello server";
    }

    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setName("steve");
        user.setAge(25);
        return user;
    }

    @GetMapping("/query")
    public User user(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
