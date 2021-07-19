## 목차

- [WEB](#web)
- [Spring](#spring)
- [Spring boot](#spring-boot)

# WEB

- [WEB 개요](./1_web)

# Spring

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


# Spring boot

- [스프링부트 개요](./2_spring_boot)