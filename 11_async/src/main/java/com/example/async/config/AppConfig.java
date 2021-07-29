package com.example.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AppConfig {
    
    /**
     * 스프링 비동기 설정
     * (스프링은 기본적으로 제한적인 쓰레드 풀 사이즈를 제공하고 있기 때문에
     * 사이즈를 늘리고 싶다면 아래와 같이 재설정 해줘야한다.)
     */
    @Bean("async-thread") // 빈 등록
    public Executor asyncThread(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(10);
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
        return threadPoolTaskExecutor;
    }
}
