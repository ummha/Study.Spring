package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @GetMapping("")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
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

    /**
     * 이렇게 해당 컨트롤러 내부에 Exception 처리 메소드를 정의하면 글로벌 해당 컨트롤러 한해서만 Exception 처리됨
     * 처리 결과 : GlobalControllerAdvice.methodArgumentNotValidException() < UserApiController.methodArgumentNotValidException()
     *           즉, 글로벌과 내부 예외처리가 동시에 있을때, 특정 컨트롤러 내부에 선언한 예외처리가 우선순위로 설정되어 내부의 예외처리가 실행됨.
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println(">>>>> Specific Advice :: UserApiController");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
