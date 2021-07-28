package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    //제약걸기
    @Pointcut("execution(* com.example.aop.controller..*.*(..))") // controller 패키지 하위 모든 클래스 모든 메소드
    private void cut() {
    }

    //제약걸기
    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    // 해당 패키지(com.example.aop.annotation) 하위에 Decode 라고 설정된 어노테이션이 붙은 메소드
    private void enableDecode() {
    }

    // Decoding
    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        System.out.println(">>> Decoding >>>");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof User) {
                User user = User.class.cast(arg);

                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");

                user.setEmail(email);
                System.out.println(user);
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println(">>> Encoding >>>");
        if(returnObj instanceof User){
            User user = User.class.cast(returnObj);

            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());

            user.setEmail(base64Email);
            System.out.println(user);
        }
    }
}
