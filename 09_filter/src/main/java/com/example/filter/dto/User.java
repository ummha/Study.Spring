package com.example.filter.dto;

import lombok.*;

//@Getter
//@Setter
@Data // getter&setter
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 모든 변수 생성자
public class User {
    private String name;
    private int age;
}
