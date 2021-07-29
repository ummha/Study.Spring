package com.example.client.controller;

import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApiController {

    private final RestTemplateService restTemplateService;
    // 요즘엔 @Autowired 보다는 생성자주입 방식으로 한다. , 롬복:@RequiredArgsConstructor
    public ApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("")
    public String getHello() {
        return restTemplateService.hello();
    }

    @GetMapping("hello2")
    public String getHello2() {
        return restTemplateService.hello2();
    }

    @GetMapping("hello3")
    public UserResponse getHello3() {
        return restTemplateService.hello3();
    }

    @GetMapping("query")
    public UserResponse query() {
        return restTemplateService.query();
    }
}
