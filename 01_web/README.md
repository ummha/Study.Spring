### 목차

- [웹(WEB) 이란?](#웹web-이란)
    - [WEB의 용도](#web의-용도)
    - [WEB의 기본 요소](#web의-기본-요소)
- [REST](#rest)
    - [RestFul 하기 위해서는](#restful-하기-위해서는)
- [URI](#uri)
  - [URI (Uniform Resource Identifier)](#uri-uniform-resource-identifier)
  - [URL (Uniform Resource Locator)](#url-uniform-resource-locator)
  - [URI 설계 원칙 (RFC-3986)](#uri-설계-원칙-rfc-3986)
- [HTTP Protocol](#http-protocol)
  - [HTTP Method](#http-method)
  - [HTTP Status Code](#http-status-code)

# 웹(WEB) 이란?

월드 와이드 웹(World Wide Web)의 줄임말로, 첫글자를 따서 WWW라고 부르기도 한다.<br/>
웹은 영어 뜻 그대로 '거미줄'이라는 뜻으로 '세상의 크기만한 거미줄', <br/>
즉, 인터넷에 연결된 컴퓨터를 통해 사람들이 정보를 공유할 수 있는 전 세계적인 정보 공간을 말한다.

### WEB의 용도
- **Web Site** - google, naver, daum, facebook, etc (HTML로 구성된 사이트들)
- **API** (Application Programming Interface) **Web Service** - Kakao Open API, Google Open API, Naver Open API, etc
- **User Interface** - Chrome, Safari, Explorer, Smart Watch, IP TV, etc

### WEB의 기본 요소

- **URI** (Uniform <span style="color:red">Resource</span> Identifier)
- **HTTP** (Hypertext Transfer <span style="color:red">Protocol</span>)
- **HTML** (Hyper Text Markup <span style="color:red">Language</span>)

# REST

- REST(Representational State Transfer : 자원의 상태 전달) : 네트워크 아키텍처

### RestFul 하기 위해서는

1. **Client**, **Server**: 클라이언트와 서버가 서로 **독립적으로 분리** 되어 있어야 한다.
2. **Stateless**: 요청에 대해서 클라이언트의 상태를 서버에 저장하지 않는다.
3. **Cache**: 클라이언트는 서버의 응답을 Cache(임시저장) 할 수 있어야 한다.<br>
  클라이언트가 Cache를 통해서 응답을 재사용할 수 있어야 하며, 이를 통해서 서버의 부하를 낮춘다.
4. **계층화(Layered System)**: 서버와 클라이어트 사이에, 방화벽, 게이트웨이, Proxy 등 다양한 계층 형태로 구성이 가능해야 하며, 이를 확장 할 수 있어야 한다.
5. **인터페이스 일관성**: 인터페이스의 일관성을 지키고, 아키텍처를 단순화시켜 작은 단위로 분리하여, 클라이언트, 서버가 독립적으로 개선 될 수 있어야 한다.
   1. 자원의 식별
   2. 메시지를 통한 리소스 조작
   3. 자기 서술적 메시지
   4. 애플리케이션 상태에 대한 엔진으로써 하이처미디어
6. **Code on Demand**(Optional): 자바 애플릿, 자바스크립트, 플래시 등 특정한 기능을 서버로부터 클라이언트가 전달받아 코드를 실행 할 수 있어야 한다.

# URI 

> 예시의 URI의 자동 링크를 없애기 위해 http:/// <- 이렇게 슬래시 3개 표기

## URI (Uniform Resource Identifier)

인터넷에서 특정 자원을 나타내는 주소 값. 해당 값은 유일 하다. (응답은 달라질 수 있다)
- 요청: http:///localhost:8080/resource/sample/1
- 응답: sample.pdf, sample.docx

## URL (Uniform Resource Locator)

인터넷 상에서의 자원, 특정 파일이 어디에 위치하는지 식별 하는 장소
- 요청: http:///localhost:8080/sample.pdf

> 즉, URL은 URI의 하위 개념이다.

## URI 설계 원칙 (RFC-3986)

- 슬래시 구분자 (`/`)는 계층 관계를 나타내는 데 사용한다.
  - http:///localhost:8080<b style="color:red">/</b>study<b style="color:red">/</b>java<b style="color:red">/</b>web-master
- URI 마지막 문자로 (`/`)는 포함하지 않는다.
  - http:///localhost:8080/study/java/web-master<b style="color:red">/</b>
- 하이픈(`-`)은 URI 가독성을 높이는데 사용한다.
  - http:///localhost:8080/study/java/web<b style="color:red">-</b>master
- 밑줄 (`_`)은 사용하지 않는다.
  - http:///localhost:8080/study/java/web<b style="color:red">_</b>master
- URI 경로에는 소문자가 적합하다.
  - http:///localhost:8080/study/<b style="color:red">JAVA</b>/web-master (X)
  - http:///localhost:8080/study/<b style="color:red">java</b>/web-master (O)
- 파일 확장자는 URI에 포함하지 않는다.
  - http:///localhost:8080/study/java/web-master<b style="color:red">.jsp</b>
- 프로그래밍 언어에 의존적인 확장자를 사용하지 않는다.
  - http:///localhost:8080/study/java/web-master<b style="color:red">.do</b>
- 구현에 의존적인 경로에 사용하지 않는다.
  - http:///localhost:8080/<b style="color:red">servlet</b>/study/java/web-master
- 세션 ID를 포함하지 않는다.
  - http:///localhost:8080/study/java/web-master?<b style="color:red">session-id=abc123</b>
- 프로그래밍 언어의 Method명을 이용하지 않는다.
  - http:///localhost:8080/study/java/web-master?<b style="color:red">action=intro</b>
- 명사에 단수형 보다는 복수형을 사용해야 한다. 컬렉션에 대한 표현은 복수로 사용
  - http:///localhost:8080/stud<b style="color:red">ies</b>/java/web-master
- 컨트롤러 이름으로는 동사나 동사구를 사용한다.
  - http:///localhost:8080/study/java/web-master/re-order
- 경로 부분 중 변하는 부분은 유일한 값으로 대체한다.
  - 생략.../study/java/web-master/lessons/<b style="color:red">{lesson-id}</b>/users/<b style="color:red">{user-id}</b>
  - 생략.../study/java/web-master/lessons/<b style="color:red">2</b>/users/<b style="color:red">100</b>
- CRUD 기능을 나타내는 것은 URI에 사용하지 않는다.
  - GET : 생략.../study/java/web-master/lessons/2/users/100/<b style="color:red">READ</b> (X)
  - DELETE : 생략.../study/java/web-master/lessons/2/users/100 (O)
- URI Query Parameter 디자인
  - URI 쿼리 부분으로 컬렉션 결과에 대해서 필터링 할 수 있다.
  - 생략.../study/java/web-master<b style="color:red">?chapter=2</b>
- URI 쿼리는 컬렉션의 결과를 페이지로 구분하여 나타내는데 사용한다.
  - 생략.../study/java/web-master<b style="color:red">?chapter=2&page=0&size=10&sort=asc</b>
- API에 있어서 서브 도메인은 일관성 있게 사용해야 한다.
  - http:///minseo.co.kr
  - http:///<b style="color:red">api.</b>minseo.cokr
  - http:///<b style="color:red">api-</b>minseo.cokr
- 클라이언트개발자 포탈 서브 도메인은 일관성 있게 만든다.
  - http:///<b style="color:red">dev-</b>minseo.cokr
  - http:///<b style="color:red">developer-</b>minseo.cokr

# HTTP Protocol

- HTTP (Hyper Text Transfer Protocol)로 RFC 2616에서 규정된 Web에서 데이터를 주고 받는 프로토콜
- 이름에는 하이퍼텍스트 전송용 프로토콜로 정의되어 있지만 실제로는 HTML, XML, JSON, Image, Voice, Video, Javascript, PDF 등 다양한 컴퓨터에서 다룰 수 있는 것은 모두 전송 할 수 있다.
- HTTP는 TCP를 기반으로 한 REST의 특징을 모두 구현하고 있는 Web기반의 프로토콜이다.

## HTTP Method

- HTTP의 요청을 특정하는 Method는 8가지가 있다.
- REST를 구현하기 위한 인터페이스이니 꼭 알아두자!

||의미|CRUD|멱등성|안정성|Path Variable|Query Parameter|DataBody|
|:---|:---|:---:|:---:|:---:|:---:|:---:|:---:|
|GET|리소스 취득|R|O|O|O|O|X|
|POST|리소스 생성, 추가|C|X|X|O|△|O|
|PUT|리소스 갱신, 추가|C / U|O|X|O|△|O|
|DELETE|리소스 삭제|D|O|X|O|O|X|
|HEAD|헤더 데이터 취득|-|O|O|-|-|-|
|OPTIONS|지원하는 메소드 취득|-|O|-|-|-|-|
|TRACE|요청메시지 반환|-|O|-|-|-|-|
|CONNECT|프록시 동작의 터널 접속으로 변경|-|X|-|-|-|-|

- ※ 멱등성: 몇번의 요청을 해도 같은 응답이 오는 것을 의미함

## HTTP Status Code

- 응답의 상태를 나타내는 코드

||의미|내용|
|:---|:---|:---|
|1XX|처리중|처리가 계속 되고 있는 상태. 클라이언트는 요청을 계속 하거나 서버의 지시에 따라서 재요청|
|2XX|성공|요청의 성공|
|3XX|리다이렉트|다른 리소스로 리다이렉트, 해당 코드를 받았을 때는 Response의 새로운 주소로 다시 재요청|
|4XX|클라이언트 에러|클라이언트의 요청에 에러가 있는 상태. 재전송 하여도 에러가 해결되지 않는다.|
|5XX|서버에러|서버 처리중 에러가 발생한 상태. 재 전송시 에러가 해결 되었을 수도 있다.|

- 자주 사용되는 코드

|코드|내용|
|:---|:---|
|200|성공|
|201|성공. 리소스를 생성 성공|
|301|리다이렉트, 리소스가 다른 장소로 반영됨을 알림|
|303|리다이렉트, Client에서 자동으로 새로운 리소스로 요청 처리|
|400|요청 오류, 파라미터 에러|
|401|권한 없음 (인증실패)|
|404|리소스 없음 (페이지를 찾을 수 없음)|
|500|서버 내부 에러 (서버 동작 처리 에러)|
|503|서비스 정지 (점검 등)|