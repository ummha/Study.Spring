package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
//@Component    // 컴포넌트로 스프링에 빈을 등록 후 전역으로 필터링 설정
@WebFilter(urlPatterns = "/api")    // 특정 url패턴으로 맵핑된 컨트롤러에서만 Filter를 하고 싶은경우 (주의: FilterApplcation.class에 @ServletComponentScan 어노테이션 추가해야한다.)
// urlPatterns <- 복수다. 즉, 배열로 설정가능
public class GlobalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /**
         * [전처리]
         */
//         HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        String url = httpServletRequest.getRequestURI();
//         HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        BufferedReader br = httpServletRequest.getReader();
//        br.lines().forEach(line -> {
//            log.info("Url : {}, Line: : {}", url, line);
//        });
        // 위와 같이 선언헤서 BufferedReader를 통해 Body를 읽게되면 후의 Controller에서 Body를 더이상 읽어올 수 없어서 IllegalStateException 예외를 발생시킨다.
        // 왜냐면 이미 GlobalFilter에서 BufferedReader로 Body의 내용을 읽어 버렸기 때문이다.

        // 솔루션 : ContentCachingRequestWrapper / ContentCachingResponseWrapper 캐싱 클래스(내용을 미리 담아두는 클래스)로 선언
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(httpServletRequest, httpServletResponse);

        /**
         * [후처리]
         * 주의해야 할 점은 chain.doFilter 후 내용을 읽어햐한다.
         */
        // req
        String url = httpServletRequest.getRequestURI();
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, request body : {}", url, reqContent);

        // res
        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse();

        log.info("response status : {}, response Body: {}", httpStatus, resContent);
    }
}
