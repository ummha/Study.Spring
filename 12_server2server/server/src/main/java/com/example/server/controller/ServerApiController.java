package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello get server";
    }

    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setName("steve");
        user.setAge(25);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public User postUser(@RequestBody User user, @PathVariable int userId, @PathVariable String userName) {
        log.info("client req : {}", user);
        log.info("userId : {}, userName : {}", userId, userName);
        return user;
    }

    @GetMapping("/query")
    public User user(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user2/{userId}/name/{userName}")
    public User postUser2(@RequestBody User user,
                          @PathVariable int userId,
                          @PathVariable String userName,
                          @RequestHeader("x-authorization") String authorization,
                          @RequestHeader("custom-header") String customHeader) {
        log.info("authorization : {}, customHeader : {}", authorization, customHeader);
        log.info("client req : {}", user);
        log.info("userId : {}, userName : {}", userId, userName);
        return user;
    }

    @PostMapping("/user3/{userId}/name/{userName}")
    public Req<User> postUser3(
            //HttpEntity<String> entity,
            @RequestBody Req<User> user,
            @PathVariable int userId,
            @PathVariable String userName,
            @RequestHeader("x-authorization") String authorization,
            @RequestHeader("custom-header") String customHeader) {
        //log.info("req : {}", entity);
        log.info("authorization : {}, customHeader : {}", authorization, customHeader);
        log.info("client req : {}", user);
        log.info("userId : {}, userName : {}", userId, userName);

        Req<User> response = new Req<>();
        Req.Header rHeader = new Req.Header();
        rHeader.setResponseCode("SUCCESS");
        response.setHeader(rHeader);
        response.setResponseBody(user.getResponseBody());

        log.info("return data : {}", response);

        return response;
    }
}
