package com.example.hello;

import com.example.hello.objectMapper.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        var objectMapper = new ObjectMapper();

        // object --> text
        // object mapper가 getter 를 사용한다.
        var user = new User("minseo", 25, "010-1234-1234");

        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text --> object
        // object mapper 는 default 생성자를 필요로 한다.
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);

    }

}
