# PORT 변경

### ✅ [application.properties](./src/main/resources/application.properties)

```properties
server.port=9090
```

# 통신 방식 예제 코드

### ✅ [1. GET 방식: GetApiController](./src/main/java/com/example/hello/controller/GetApiController.java)

- [**DTO: UserRequest**](./src/main/java/com/example/hello/dto/UserRequest.java)

### ✅ [2. POST 방식: PostApiController](./src/main/java/com/example/hello/controller/PostApiController.java)

- [**DTO: PostRequest**](./src/main/java/com/example/hello/dto/PostRequest.java)

### ✅ [3. PUT 방식: PutApiController](./src/main/java/com/example/hello/controller/PutApiController.java)

- [**DTO: PutRequest**](./src/main/java/com/example/hello/dto/PutRequest.java)
- [**DTO: CarDto**](./src/main/java/com/example/hello/dto/CarDto.java)

### ✅ [4. DELETE 방식: DeleteApiController](./src/main/java/com/example/hello/controller/DeleteApiController.java)

### ✅ [5. Response 방식 (`text`, `json`, `ResponseEntity<T>`): ApiController](./src/main/java/com/example/hello/controller/ApiController.java)

- [**DTO: User**](./src/main/java/com/example/hello/dto/User.java)