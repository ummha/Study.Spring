package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 팁!>>
 * [ @Component와 @Bean의 차이점 ]
 * - @Bean 같은 경우 클래스에 선언 할 수 없고 @Bean 어노테이션은 메소드에 선언이 가능하다. 즉, 컴포넌트를 통해서 클래스 단위로 빈을 등록시켜줘야 한다.
 * [ Configuration 차이 ]
 * - 하나의 클래스에 여러가지 빈을 등록할 수 있다.
 */

/**
 * 어노테이션을 직접 커스텀마이징해서
 * 특정 메소드의 실행 시간을 기록하기
 */

@Aspect
@Component
public class TimerAop {

    //제약걸기
    @Pointcut("execution(* com.example.aop.controller..*.*(..))") // controller 패키지 하위 모든 클래스 모든 메소드
    private void cut() {
    }

    //제약걸기
    @Pointcut("@annotation(com.example.aop.annotation.Timer)")  // 해당 패키지(com.example.aop.annotation) 하위에 Timer 라고 설정된 어노테이션이 붙은 메소드
    private void enableTimer(){

    }

    /**
     * @Before 와 @After는 시간을 공유할 수 없기 때문에 @Around 활용
     */
    @Around("cut() && enableTimer()")   // 두가지 조건을 같이 쓰겠다는 말
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // proceed() : 해당 메소드 호출
        // 반환 : 해당 메소드가 특정한 값이나 객체를 리턴하면 result에 담긴다. void면 null이 담긴다.
        Object result = proceedingJoinPoint.proceed();
        System.out.println(result);
        stopWatch.stop();

        System.out.println(">>> @Around >>>");
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }
}
