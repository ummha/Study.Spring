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

