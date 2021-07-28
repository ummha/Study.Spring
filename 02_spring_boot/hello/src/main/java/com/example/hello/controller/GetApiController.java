package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    /*
    이 컨트롤러에서는 다양한 GET Method로 클라이언트와 통신하는 다양한 방식을 알아본다.
    주로 [방식 6.]을 협업에서 주로 사용하고 추천되는 방식이다.
     */

    /**
     * GET 방식 1. GETMapping
     * 요즘방식
     */
    @GetMapping(path = "/hello")    // http://localhost:9090/api/get/hello
    public String hello(){
        return "get Hello";
    }

    /**
     * GET 방식 2. RequestMapping
     * 예전에 사용하던 방식
     * @RequestMapping은 get / post / put / delete HTTP method를 받을 수 있다.
     */
    @RequestMapping(path = "/hi", method = RequestMethod.GET)  // get http://localhost:9090/api/get/hi
    public String hi(){
        return "hi";
    }

    /**
     * GET 방식 3. Path Variable
     * path의 변수를 유동적으로 받는 방식
     * 주의할점 >>>
     * 1. {} 괄호안에 선언된 명칭 값을 파라미터로 전달 받을시 @PathVariable 어노테이션을 선언 후 {}괄호안의 명칭과 같은 변수이름을 선언한다.
     * ex) .../{id} => pathVariable(@PathVariable String id)
     * 2. 만일 {}괄호안의 명칭과 다른 변수이름을 사용하고 싶을때에는 @PathVariable에 있는 name 옵션을 설정해서 사용한다.
     * ex) .../{id} => pathVariable(@PathVaiable(name = "id") String userId)
     * @return
     */
    @GetMapping("/path-variable/{name}")    // http://localhost:9090/api/get/path-variable/{name}
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    /**
     * GET 방식 4. Query Param - 1
     * 아래의 URL 주석과 같이 ?과 &를 통해서 Key, Value 형식으로 요청이 올때 @RequestParam 어노테이션을 통해서 사용할 수 있는 방식이다.
     * 방식4는 @RequestParam Map 으로 받는 방식을 알아본다.
     * 장점 >>> 파라미터 코드가 짧고 깔끔함
     * 단점 >>> 직관성 없음 -> 가독성 떨어짐
     * 파라미터 코드가 짧고 깔끔하지만 다시 Map에 있는 값들을 파싱하고 자료형도 맞춰줘야하기 때문에 서버쪽 에러가 발생하기 쉽고
     * 어떤 데이터 요청을 받는지 직관적으로 알 수 없다
     * @return
     */
    // http://localhost:9090/api/get/query-param01?user=minseo&email=minseo@gmail.com&age=27
    @GetMapping(path = "/query-param01")
    public String queryParam01(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    /**
     * GET 방식 5. Query Param - 2
     * @RequestParam Map 으로 받는 방식과 다르게 명시적으로 변수들을 하나하나 @RequestParam을 선언해주는 방식이다.
     * 장점 >>> 직관성이 높다
     * 초기에 받는 변수들의 자료형이 이미 정해져 있기 때문에 서버쪽에서 요청 데이터 받을 때의 오류가 없다.
     * (발생한다해도 보통 자료형이 안맞기 때문에 발생하는 오류이기 때문에 Client에서 해결해줘야한다.)
     * 단점 >>> 파라미터 코드가 길어짐
     * 하나의 요청 데이터를 받을때에는 상관이없지만 많은 요청 데이터를 받아야할시 오히려 가독성이 떨어진다.
     * @return
     */
    @GetMapping(path = "query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " + age;
    }

    /**
     * GET 방식 6. Query Param - 3
     * 요청 데이터를 객체 형태로 받는 방식이며, 이러한 객체를 DTO(Data Transfer Object)라고 한다.
     * - 먼저 Request DTO 객체를 만들고 (단, DTO객체에 Getter Setter가 정의되어야한다.) 파라미터로 DTO를 받는다.
     * - 파라미터에 DTO를 선언시 **@RequestParam 어노테이션은 붙이지 않는다.**
     * 장점 >>> 재사용성, 가독성 좋음 또한 데이터 관리가 수월함.
     * 현업에서 주로 사용하는 방식**
     * @return
     */
    @GetMapping(path = "query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
