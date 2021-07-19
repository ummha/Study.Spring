package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HTML resources 를 응답하는 방식을 알아보자
 */
@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    //ResponseEntity
    @ResponseBody
    @GetMapping("/user")
    public User user() {
        var user = new User(); // var = 타입 추론 방식
        user.setName("minseo");
        user.setAddress("주소123@123");
        return user;
    }
}
