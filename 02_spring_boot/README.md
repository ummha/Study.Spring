## 목차

- [Spring Boot](#spring-boot)
    - [스프링 부트란 ?](#스프링-부트란-)
    - [스프링 부트의 주요 목표](#스프링-부트의-주요-목표)
    - [Build Tool](#build-tool)
    - [Servlet Containers](#servlet-containers)
  - [클라이언트와 통신하는 방식 예제 코드 확인해보기](#클라이언트와-통신하는-방식-예제-코드-확인해보기)

# Spring Boot

### 스프링 부트란 ?

- Spring Boot는  단순히 실행되며, **프로덕션 제품 수준의 스프링 기반 어플리케이션을 쉽게 만들 수 있다.**
- Spring Boot 어플리케이션에는 **Spring 구성이** 거의 필요 하지 않다.
- Spring Boot **java -jar 로 실행하는 Java 어플리케이션**을 만들 수 있다.

### 스프링 부트의 주요 목표

- **Spring 개발에 대해 빠르고**, 광범위하게 적용할 수 있는 경험
- **기본값 설정**이 있지만 설정을 바꿀 수 있다.
- **대규모 프로젝트**에 공통적인 비 기능 제공 (보안, 모니터링 등등)
- **XML 구성 요구사항**이 전혀 없음

> 즉, 스프링 부트는
> - 어플리케이션 개발에 필수 요소들만 모아두었다.
> - 간단한 설정으로 개발 및 커스텀이 가능하다.
> - 간단하고, 빠르게 어플리케이션 실행 및 배포가 가능하다.
> - 대규모프로젝트(운영환경)에 필요한 비 기능적 기능도 제공한다.
> - 오랜 경험에서 나오는 안정적인 운영이 가능하다.
> - Spring에서 불편한 설정이 없어졌다. (XML 설정 등)

### Build Tool

|Name|version|
|:---|:---|
|Maven|3.3+|
|Gradle|4.x (4.4 and later) and 5.x|

### Servlet Containers

|Name|servlet version|
|:---|:---|
|Tomcat 9.x|3.3|
|Jetty 9.4|3.1|
|Undertow 2.0|4.0|
|Netty|-|

## 클라이언트와 통신하는 방식 예제 코드 확인해보기

- [🟩 **hello Project README**](./hello)