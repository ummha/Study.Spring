package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * request와 response 로그 활용
 */

@Aspect
@Component
public class ParameterAop {

    //제약걸기
    @Pointcut("execution(* com.example.aop.controller..*.*(..))") // controller 패키지 하위 모든 클래스 모든 메소드
    private void cut() {}

    @Before("cut()")
    private void before(JoinPoint joinPoint) {
        System.out.println("### TEST JoinPoint ###");
        System.out.println(joinPoint.getSignature());   // String com.example.aop.controller.ResApiController.get(Long,String)
        System.out.println(joinPoint.getKind());    // method-execution
        System.out.println(joinPoint.getStaticPart());  // execution(String com.example.aop.controller.ResApiController.get(Long,String))
        System.out.println(joinPoint.getSourceLocation());  // org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint$SourceLocationImpl@299532ea

        System.out.println(">>> start @Before >>>");
        var methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("method : " + methodSignature.getName());    // get
        System.out.println(methodSignature.getMethod());    // public java.lang.String com.example.aop.controller.ResApiController.get(java.lang.Long,java.lang.String)
        System.out.println(methodSignature.toString()); // String com.example.aop.controller.ResApiController.get(Long,String)
        System.out.println(methodSignature.getReturnType());    // class java.lang.String
        System.out.println(Arrays.toString(methodSignature.getParameterNames()));   // [id, name]
        System.out.println(Arrays.toString(methodSignature.getParameterTypes()));   // [class java.lang.Long, class java.lang.String]

        Object[] args = joinPoint.getArgs(); // getArgs() 매개변수에 들어가는 객체 배열
        for (Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName() + ", value : " + obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    private void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println(">>> start @AfterReturning >>>");
        System.out.println(returnObj);
    }
}
