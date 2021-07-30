package com.example.server.controller;

import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello get server";
    }

    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setName("steve");
        user.setAge(25);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public User postUser(@RequestBody User user, @PathVariable int userId, @PathVariable String userName){
        log.info("client req : {}", user);
        log.info("userId : {}, userName : {}", userId, userName);
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
