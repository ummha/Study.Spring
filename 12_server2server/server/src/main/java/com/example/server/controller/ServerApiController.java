package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;

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

    /**
     * https://openapi.naver.com/v1/search/local.json
     * ?query=%EA%B0%88%EB%B9%84%EC%A7%91
     * &display=10
     * &start=1
     * &sort=random
     * @return
     */
    @GetMapping("/naver")
    public String naver() {

        // encoding
        String query = "중국집";
        //String encode = Base64.getEncoder().encodeToString(query.getBytes(StandardCharsets.UTF_8)); // 오류

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", query)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(StandardCharsets.UTF_8) // encode() 기본적으로 StandardCharsets.UTF_8 으로 되어있음
                //.encode(Charset.forName("UTF-8"))'    // 이것도 가능
                .build()
                .toUri();

        log.info(uri.toString());

        RestTemplate restTemplate = new RestTemplate();

        // head 설정
        RequestEntity<Void> req = RequestEntity.get(uri)
                .header("X-Naver-Client-Id", "") //네이버 클라이언트 아이디
                .header("X-Naver-Client-Secret", "")    // 네이버 클라이언트 시크릿키
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);

        return result.getBody();
    }
}
