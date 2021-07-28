package com.example.hello.dto;

/**
 * DTO (Data Transfer Object)
 * Getter,Setter가 존재 해야함
 * 롬복 Lombok 라이브러리를 통해서 Getter,Setter를 어노테이션으로 선언가능 ( @Data )
 * 만일 클라이언트에서 보낸 Query Param과의 매핑 원활하지 않을시
 * DTO와의 파싱이 제대로 이루어지지 않아 데이터 누락이 발생할 수 있으니,
 * Api 디자인할때 주의해서 만들어줘야 한다.
 */
public class UserRequest {
    private String name;
    private String email;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
