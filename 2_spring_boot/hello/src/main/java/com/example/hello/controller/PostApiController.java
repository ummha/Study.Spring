package com.example.hello.controller;

import com.example.hello.dto.PostRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    /**
     * POST 방식 1. @PostMapping
     * Map으로 request데이터를 받는 방식으로 @RequestBody 어노테이션을 명시적으로 작성해줘야 한다.
     */
    @PostMapping("/post01")
    public void post01(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });
    }

    /**
     * POST 방식 2. @PostMapping
     * DTO로 request데이터를 받는 방식으로 @RequestBody 어노테이션을 명시적으로 작성해줘야 한다.
     */
    @PostMapping("/post02")
    public void post02(@RequestBody PostRequest postRequest) {
        System.out.println(postRequest.toString());
    }
}
