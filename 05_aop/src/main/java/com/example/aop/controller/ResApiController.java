package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        System.out.println(">>> run get() >>>");
        System.out.println(id);
        System.out.println(name);

        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        System.out.println(">>> run post() >>>");
        System.out.println("post Method: " + user);
        return user;
    }

    @Timer  // 직접 만든 어노테이션
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {

        // db logic

        Thread.sleep(1000 *2);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {
        System.out.println(">>> run put() >>>");
        System.out.println("put Method: " + user);
        return user;
    }
}
