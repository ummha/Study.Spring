package com.example.interceptor.interceptor;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Arrays;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 만약 body의 내용을 읽고 싶다면 spring boot filter에서 했던 작업을 똑같이 해줘야 하는데,
         * spring boot filter에서 만든 Filter 클래스와 같이 Filter를 구현하고
         * 캐싱클래스를 chain.doFilter() 매개변수로 넘겨주면
         * 인터셉터 클래스에서 캐싱클래스로 형변환이 가능하다.
         * 만일, doFilter()로 캐싱클래스로 변환된 request를 넘기지 않으면
         * 인터셉터 단에서 캐싱클래스로 형변환이 불가능하다.
         *
         * (현재 이 프로젝트 예제에서는 위와 같은 내용을 다루진 않음)
         */
        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();

        log.info("request url : {}", url);
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation: {}", hasAnnotation);

        // 나의 서버는 모두 public 으로 동작을 하는데
        // 단! Auth 권한을 가진 요청에 대해서는 세션, 쿠키 체크
        if(hasAnnotation){
            //권한체크
            //예제로는 쿼리를 체크하지만 실제로는 세션이나 쿠키를 체크해야함
            String query = uri.getQuery();
            log.info("query : {}", query);

            if(query.equals("name=steve")) return true;

            throw new AuthException("잘못된 권한임");
        }

        /**
         * True / False 반환
         * true를 반환 할 경우 : interceptor 단 너머의 컨트롤러까지 호출이 넘어가고
         * false를 반환 할 경우 : interceptor에서 바로 dispatcher로 넘어간다. (그래서 false를 반환할때 Controller에 있는 로그가 찍히지 않았던 거임)
         */
        return true;
    }

    /**
     * 특정 어노테이션이 붙어있는지 확인하는 메소드 (현재 예시에서는 @Auth를 확인한다.)
     * @param handler
     * @param clazz
     * @return
     */
    public boolean checkAnnotation(Object handler, Class clazz){
        // resource javascript, html / resource 파일에 대한 요청일 경우는 무조건 true를 반환
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // Auth annotation이 있을때는 true
        if(null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)){
            return true;
        }
        return false;
    }
}
