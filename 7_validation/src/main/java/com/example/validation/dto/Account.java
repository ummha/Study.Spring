package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Account {
    @NotBlank
    private String name;

    @Max(value = 90)
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
    private String phoneNumber;

    @Size(min = 6, max = 6)
    private String reqYearMonth; // yyyyMM

    /**
     * 직접 커스텀한 검증 어노테이션으로 같은 어노테이션만 붙이면 여러곳에서 재사용이 가능하다.
     */
    @YearMonth(pattern = "yyyyMM")
    private String yearMonth;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    /**
     * 검증이 애매한 경우 이렇게 @AssertTime 어노테이션과 isXxxxXxx 메소드명을 통해 Custom 검증 로직을 구현할 수 있다.
     * 하지만 이 방법도 해당 클래스에서만 적용되는 것이기 때문에 동일한 검증이 필요한 클래스에서 매번 같은 코드를 구현해야한다.
     * yearMonth의 어노테이션을 비교해 보자!
     * @return
     */
    @AssertTrue(message = "yyyyMM의 형식에 맞지 않습니다.")
    public boolean isReqYearMonthValidation() {
        try {
            LocalDate localDate = LocalDate.parse(this.reqYearMonth + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                ", yearMonth='" + yearMonth + '\'' +
                '}';
    }
}
