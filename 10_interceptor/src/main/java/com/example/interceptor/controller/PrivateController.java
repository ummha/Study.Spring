package com.example.interceptor.controller;

import com.example.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/private")
@Auth   // @Auth 어노테이션이 붙어있을 경우 세션을 검사해서 통과 여부를 확인하는 interceptor 를 거치게 만듦
public class PrivateController {

    @GetMapping("/hello")
    public String hello() {
        log.info("private hello controller");
        return "private hello";
    }
}
