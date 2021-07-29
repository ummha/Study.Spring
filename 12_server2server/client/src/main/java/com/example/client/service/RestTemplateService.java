package com.example.client.service;

import com.example.client.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    // http://localhost/api/server/hello
    // response

    // get response by Object
    // 헤더와 같은 상세 정보 조회 불가능
    public String hello(){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }

    // get response by ResponseEntity
    // 헤더와 같은 상세 정보 조회 가능
    public String hello2(){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    public UserResponse hello3(){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/user")
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    public UserResponse query() {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/query")
                .queryParam("name", "minseo")
                .queryParam("age", 27)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }
}
