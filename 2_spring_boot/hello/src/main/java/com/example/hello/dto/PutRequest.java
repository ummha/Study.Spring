package com.example.hello.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

/**
 * @JsonProperty 와 @JsonNaming 의 차이점
 * - @JsonProperty는 한가지 변수에 대해서 이름을 지어주는 어노테이션인 반면에,
 * - @JsonNaming은 일괄적으로 모든 JSON 룰을 정해줄 수 있다.
 *
 * 주의 : deprecated PropertyNamingStrategy by ~2.12
 * 해결방법 : Use PropertyNamingStrategies
 */
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PutRequest {
    private String name;
    private int age;

    private List<CarDto> carList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<CarDto> getCarList() {
        return carList;
    }

    public void setCarList(List<CarDto> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "PutRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }
}
