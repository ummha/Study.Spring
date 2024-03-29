package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@RestController
@RequestMapping("/api")
@Validated // http Get method에서 해당 파라미터 별로 검증을 하기 위한 어노테이션
public class ApiController {

    /*
    @GetMapping("")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        int a = 10 + age; // 해당 코드에 인위적으로 NullpointException 예외 발생시킨다.

        return user;
    }
    */

    @GetMapping("")
    public User get(
            @Size(min = 2)
            @RequestParam String name,

            @NotNull
            @Min(1)
            @RequestParam Integer age) {

        User user = new User();
        user.setName(name);
        user.setAge(age);

        int a = 10 + age; // 해당 코드에 인위적으로 NullpointException 예외 발생시킨다.

        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        System.out.println(user);

        return user;
    }
}
