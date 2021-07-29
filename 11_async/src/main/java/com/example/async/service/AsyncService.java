package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    @Async  // 비동기 어노테이션 , 단, response 객체를 넘기지 않으므로 그저 또다른 쓰레드만 돌 뿐이다.
    public void hello() {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
                log.info("thread sleep ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 비동기 및 response하는 방식
    @Async("async-thread")
    public CompletableFuture run(){
        return new AsyncResult(hello2()).completable();
    }

    public String hello2() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
                log.info("thread sleep ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "async return hello";
    }

    /**
     * [추가]
     * @Async 어노테이션은 AOP 기반이기 때문에 Proxy 패턴을 탄다.
     * 그래서 public 접근제한자 메소드에서만 어노테이션 추가가 가능하다.
     * 또한 같은 클래스 내에서 메소드를 호출할 수 없다.
     *     @Async("async-thread")
     *     public CompletableFuture run(){
     *         hello2() <- X 안됌
     *         return new AsyncResult(hello2()).completable();
     *     }
     */
}
