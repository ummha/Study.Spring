package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 해당 클래스는 REST API를 처리하는 Controller로 등록됨
@RequestMapping("/api") // URL를 지정해주는 어노테이션
public class ApiController {

    @GetMapping("/hello")   // http://localhost:9090/api/hello
    public String hello(){
       return "hello spring boot";
    }

    /** 응답하는 방법 **/

    /**
     * TEXT로 응답하기
     * @param account
     * @return
     */
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    /**
     * JSON으로 응답하기 (http status code : 200)
     * 간단한 처리순 >>>
     * 요청 (요청 데이터) -> ObjectMapper -> object -> method() ->
     * 응답하기 -> object -> ObjectMapper -> json -> 응답 response
     * @param user
     * @return
     */
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user;
    }

    /**
     * http status code : 201 로 응답하기
     * 응답에 대한 커스터마이징이 필요하다면 ResponseEntity 객체를 통해 다양한 설정을 할 수 있다.
     * @param user
     * @return
     */
    @PutMapping("/json/put")
    public ResponseEntity<User> put(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
