package com.example.interceptor.config;

import com.example.interceptor.interceptor.AuthInterceptor;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor    // final로 선언된 객체들을 생성자에서 주입 받을 수 있도록 생성자를 만듦
public class MvcConfig implements WebMvcConfigurer {
    //Spring에서 @Autowired 어노테이션으로 받을 수 있는 방법이 있지만 순환참조가 될 가능성이 있어서 요즘은 롬복의 @RequiredArgsConstructor를 주로 씀
    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(authInterceptor);   // 등록 (전체)
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*"); // 특정 url 요청에 대해서만 처리하고 싶을때
        //registry.addInterceptor(authInterceptor).excludePathPatterns("/api/public/*");    // 제외하고자 하는 url을 설정하고 싶을때
        /**
         * 추가로 현재는 authInterceptor 만 등록되어 있지만
         * 다른 interceptor도 추가로 등록하고 싶으면
         * 추가한 ( registry.addInterceptor() ) 순서되로 동작하니
         * 인증의 과정을 여러가지 depth를 두고 활용할 수 있다.
         */
    }
}
