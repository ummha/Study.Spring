package com.example.hello.controller;

import com.example.hello.dto.PutRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    /**
     * PUT 방식 1.
     * @PutMapping 어노테이션을 꼭 붙여주고,
     * @RequestBody 와 상황에 따라 @PathVariable 도 사용가능하다
     * @RestController로 정의하면 해당 response객체를 JSON형태로 응답해준다.
     */
    @PutMapping("/put/{userId}")
    public PutRequest put(@RequestBody PutRequest putRequest, @PathVariable(name = "userId") Long userId){
        System.out.println(putRequest.toString());
        System.out.println(userId);
        return putRequest;
    }
}
