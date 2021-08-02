## 목차

- [WEB](#web)
- [Spring](#spring)
  - [IoC (Inversion of Control)](#ioc-inversion-of-control)
    - [IoC 예제 코드](#ioc-예제-코드)
  - [DI (Dependency Injection)](#di-dependency-injection)
  - [AOP (Aspect Oriented Programming)](#aop-aspect-oriented-programming)
    - [관점 지향 프로그램](#관점-지향-프로그램)
    - [AOP 주요 Annotation](#aop-주요-annotation)
    - [AOP 예제 코드](#aop-예제-코드)
- [Spring Boot](#spring-boot)
  - [Spring Boot Annotations](#spring-boot-annotations)
  - [Spring Boot Validation](#spring-boot-validation)
    - [예제 코드](#예제-코드)
    - [예제 코드의 문제점](#예제-코드의-문제점)
    - [Annotation 기반 Validation](#annotation-기반-validation)
    - [Gradle dependencies](#gradle-dependencies)
    - [Bean validation spec](#bean-validation-spec)
    - [핸드폰번호 정규식](#핸드폰번호-정규식)
    - [spring boot basic validation](#spring-boot-basic-validation)
    - [spring boot custom validation](#spring-boot-custom-validation)
  - [Spring Boot Exception](#spring-boot-exception)
    - [예제 코드](#예제-코드-1)
  - [Spring Boot Filter and Interceptor](#spring-boot-filter-and-interceptor)
    - [Filter](#filter)
    - [Filter 예제 코드](#filter-예제-코드)
    - [Interceptor](#interceptor)
    - [Interceptor 예제 코드](#interceptor-예제-코드)
  - [비동기 처리하기](#비동기-처리하기)
- [Server(Client) to Server 의 연결](#serverclient-to-server-의-연결)
- [JUnit](#junit)
  - [Junit 예제 코드](#junit-예제-코드)

# WEB 

[🔼](#목차)

- [WEB 개요](./01_web)

# Spring

[🔼](#목차)

- Spring 1.0 버전은 2004년 3월 출시
  - 지난 20년까지의 세월 동안 단 한번도 자바 엔터프라이즈 어플리케이션 개발의 최고의 자리를 차지
- 스프링 프레임워크의 구성은 20여가지의 구성(https://spring.io/projects/spring-framework)
  - 이러한 모듈들은 스프링의 핵심기능(DI, AOP, etc)을 제공해 주며, 필요한 모들만 선택하여 사용 가능.
- 현재 단일 아키텍처(모놀리스)마이크로서비스 아키텍처로 변환 중
- 여러 가지 모듈이 있지만 그 중에서 단연
  - **스프링 부트, 스프링 클라우드, 스프링 데이터, 스프링 배치, 스프링 시큐리티**에 중점을 둔다.
- Spring의 과제는 "테스트의 용이성", "느슨한 결합"에 중점을 두고 개발
- 2000년대 초의 자바 EE 애플리케이션은 작성/테스트가 매우 어려웠으며, 한번 테스트하기가 번거로웠다. 이로 인하여, 느슨한 결합이 된 애플리케이션 개발이 힘든 상태였으며, 특히 데이터베이스와 같이 외부에 의존성을 두는 경우 단위테스트가 불가능했다.
- IoC의 등장
  - 스프링이 다른 프레임워크와 가장 큰 차이점이 IoC를 통한 개발 진행
- AOP
  - AOP를 사용하여, 로깅, 트랜잭션 관리, 시큐리티에서의 적용 등 AspectJ와 같이 완벽하게 구현된 AOP와 통합하여 사용 가능하다.

![](./images/spring.jpg)

## IoC (Inversion of Control)

[🔼](#목차)

- 스프링에서는 일반적인 Java 객체를 new로 생성하여 개발자가 관리 하는 것이 아닌 Spring Contrainer에 모두 맡긴다.
- 즉, 개발자에서 -> 프레임워크로 **제어**의 객체 관리의 **권한이 넘어 갔음** 으로 **"제어의 역전"** 이라고 한다.

### IoC 예제 코드

[🔼](#목차)

- [java ioc / di](./03_ioc)
- [spring ioc](./04_spring-ioc)

## DI (Dependency Injection)

[🔼](#목차)

- 장점
  - 의존성으로 부터 격리시켜 코드 테스트에 용이하다.
  - DI를 통하여, 불가능한 상황을 Mock와 같은 기술을 통하여, 안정적으로 테스트 가능하다.
  - 코드를 확장하거나 변경 할때 영향을 최소화 한다. (추상화)
  - 순환참조를 막을 수 있다.

## AOP (Aspect Oriented Programming)

[🔼](#목차)

### 관점 지향 프로그램

[🔼](#목차)

스프링 어플리케이션은 대부분 특별한 경우를 제외 하고는 MVC 웹 어플리케이션에서는 Web Layer, Business Layer, Data Layer 로 정의

- Web Layer : REST API 를 제공하며, Client 중심의 로직 적용
- Business Layer : 내부 정책에 따른 logic을 개발하여, 주로 해당 부분을 개발
- Date Layer : 데이터 베이스 및 외부와의 연동을 처리

### AOP 주요 Annotation

[🔼](#목차)

|Annotation|의미|
|---|---|
|`@Aspect`|자비에서 널리 사용하는 AOP 프레임워크에 포함되며, AOP를 정의하는 Class에 할당|
|`@Pointcut`|기능을 어디에 적용시킬지, 메소드? Annotation? 등 AOP를 적용 시킬 지점을 설정|
|`@Before`|메소드 실행하기 이전|
|`@After`|메소드가 성공적으로 실행 후, 예외가 발생 되더라도 실행|
|`@AfterReturing`|메소드 호출 성공 실행 시 (Not Throws)|
|`@AfterThrowing`|메소드 호출 실패 예외 발생 (Throws)|
|`@Around`|Before / After 모두 제어|

### AOP 예제 코드

[🔼](#목차)

- [aop](./05_aop)

# Spring Boot

[🔼](#목차)

- [스프링부트 개요](./02_spring_boot)

## Spring Boot Annotations

[🔼](#목차)

|Annotation|의미|
|---|---|
|`@SpringBootApplication`|Spring boot application으로 설정|
|`@Controller`|View를 제공하는 controller로 설정|
|`@RestController`|REST API를 제공하는 controller로 설정|
|`@RequestMapping`|URL 주소를 맵핑|
|`@GetMapping`|Http GetMethod URL 주소 맵핑|
|`@PostMapping`|Http PostMethod URL 주소 맵핑|
|`@PutMapping`|Http PutMethod URL 주소 맵핑|
|`@DeleteMapping`|Http DeleteMethod URL 주소 맵핑|
|`@RequestParam`|URL Query Parameter 맵핑|
|`@RequestBody`|Http Body를 Parsing 맵핑|
|`@Valid`|POJO Java class의 검증|

|Annotation|의미|
|---|---|
|`@Configration`|1개 이상의 bean을 등록 할 때 설정|
|`@Component`|1개 Class 단위로 등록 할 때 사용|
|`@Bean`|1개의 외부 library로부터 생성한 객체를 등록시 사용|
|`@Autowired`|DI를 위한 곳에 사용|
|`@Qualifier`|@Autowired 사용시 bean이 2개 이상 일때 명시적 사용|
|`@Resource`|@Autowired + @Qualifier의 개념으로 이해|
|`@Aspect`|AOP 적용시 사용|
|`@Before`|AOP 메소드 이전 호출 지정|
|`@After`|AOP 메소드 호출 이후 지정 예외 발생 포함|
|`@Around`|AOP 이전/이후 모두 포함 예외 발생 포함|
|`@AfterReturning`|AOP 메소드의 호출이 정상일 때 실행|
|`@AfterThrowing`|AOP시 해당 메소드가 예외 발생시 지정|


## Spring Boot Validation

[🔼](#목차)

Validation이란 프로그래밍에 있어서 가장 필요한 부분이다. 특히 Java에서는 null 값에 대해서 접근  
하려고 할 때 null pointer exception이 발생 함으로, 이러한 부분을 방지 하기 위해서 미리 검증을 하는  
과정을 Validation 이라고 한다.

### 예제 코드

[🔼](#목차)

```java
public void run(String id, String pw, int age){
  if(id == nul || pw == null){
    return;
  }
  if(age == 0){
    return;
  }
}
```

### 예제 코드의 문제점

[🔼](#목차)

1. 검증해야 할 값이 많은 경우 코드의 길이가 길어 진다.
2. 구현에 따라서 달라 질 수 있지만 Service Logic과의 분리가 필요하다.
3. 흩어져 있는 경우 어디에서 검증을 하는지 알기 어려우며, 재사용의 한계가 있다.
4. 구현에 따라 달라 질 수 있지만, 검증 Logic이 변경 되는 경우 테스트 코드 등 참조하는 클래스에서 Logic이 변경되어야 하는 부분이 발생 할 수 있다.

### Annotation 기반 Validation

[🔼](#목차)

|annotation|검증 내용|
|---|---|
|`@Size`|문자 길이 측정 (int Tyoe 불가)|
|`@NotNull`|null 불가|
|`@NotEmpty`|null, "" 불가|
|`@NotBlank`|null, "", " " 불가|
|`@Past`|과거 날짜|
|`@PastOrPresent`|오늘이나 과거 날짜|
|`@Future`|미래 날짜|
|`@FutureOrPresent`|오늘이거나 미래 날짜|
|`@Pattern`|정규식 적용|
|`@Max`|최대값|
|`@Min`|최소값|
|`@AssertTrue`/False|별도 Logic 적용|
|`@Valid`|해당 object validation 실행|

### Gradle dependencies

[🔼](#목차)

`implementation group: 'org.springframework.boot', name: 'spring-boot-starter-validation', version: '2.5.2'`

- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation

### Bean validation spec

[🔼](#목차)

- https://beanvalidation.org/2.0-jsr380/

### 핸드폰번호 정규식

[🔼](#목차)

- `"^\\d{2,3}-\\d{3,4}-\\d{4}$"`

### spring boot basic validation

[🔼](#목차)

- [simple validation project](./07_validation)

### spring boot custom validation

[🔼](#목차)

- `AssertTrue/False`와 같은 method 지정을 통해서 Custom Logic 적용 가능
- `ConstraintValidator`를 적용하여 재사용이 가능한 Custom Logic 적용 가능
- [custom validation project](./07_validation)

## Spring Boot Exception

[🔼](#목차)

- Exception 처리

Web Application 의 입장에서 바라 보았을때, 에러가 났을 때 내려줄 수 있는 방법은 많지 않다.

    1. 에러 페이지
    2. 4xx Error or 5xx Error
    3. Client가 200 외에 처리를 하지 못 할 때는 200을 내려주고 별도의 에러 Message 전달

|annotation|설명|
|---|---|
|`@ControllerAdvice`|Global 예외 처리 및 특정 package / Controller 예외처리|
|`@ExceptionHandler`|특정 Controller의 예외처리|

### 예제 코드

[🔼](#목차)

- [spring boot exception project](./08_exception)

## Spring Boot Filter and Interceptor

[🔼](#목차)

### Filter

[🔼](#목차)

Filter란 Web Application에서 관리되는 영역으로써 Spring Boot Framework에서 Client로 부터 오는 요청/응답  
에 대해서 최초/최종 단계의 위치에 존재하며, 이를 통해서 요청/응답의 정보를 변경하거나, Spring에 의해서  
데이터가 변환되기 전의 순수한 Client의 요청/응답 값을 확인 할 수 있다.

**유일하게 ServletRequest, ServletReponse 의 객체를 변환** 할 수 있다.

주로 Spring Framework에서는 request / response의 Logging 용도로 활용하거나,  
인증과 관련된 Logic들을 해당 Filter에서 처리 한다.

이를 선/후 처리 함으로써, Service business logic과 분리 시킨다.

### Filter 예제 코드

[🔼](#목차)

- [spring boot filter project](./09_filter)

### Interceptor

[🔼](#목차)

Interceptor란 Filter와 매우 유사한 형태로 존재 하지만, 차이점은 Spring COntext에 등록된다.

AOP와 유사한 기능을 제공 할 수 있으며,  
주로 **인증 단계**를 처리 하거나, Logging을 하는 데에 사용한다.

이를 선/후 처리 함으로써, Service business logic과 분리 시킨다.

### Interceptor 예제 코드

[🔼](#목차)

-  [spring boot interceptor project](./10_interceptor)

## 비동기 처리하기

[🔼](#목차)

- [spring boot async project](./11_async)

# Server(Client) to Server 의 연결

[🔼](#목차)

- [server to server project](./12_server2server)


# JUnit

[🔼](#목차)

- **TDD (Test-driven Development)**

테스트 주도 개발에서 사용하지만, 코드의 유지 보수 및 운영 환경에서의 에러를 미리 방지 하기 위해서  
단위 별로 검증 하는 테스트 프레임워크

- **단위테스트**

작성한 코드가 기대하는 대로 동작을 하는지 검증 하는 절차

- **JUnit**

Java기반의 단위 테스트를 위한 프레임워크  
Annotation 기반으로 테스트를 지원하며, Assert를 통하여, (예상, 실제) 를 통해 검증

## Junit 예제 코드

- [java gradle Junit project](./13_junit)
- [spring boot Junit project](./14_spring_junit)