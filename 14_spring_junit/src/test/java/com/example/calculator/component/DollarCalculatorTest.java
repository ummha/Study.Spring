package com.example.calculator.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

/**
 * 통합 테스트
 */

@SpringBootTest // 통합테스트 (모든 빈이 등록됨)
// @SpringBootTest 어노테이션을 붙이는 순간 아래의 @Import 모든 빈이 주입되기 때문에 생략한다.
//@Import({MarketApi.class, DollarCalculator.class})    // 필요한 클래스 임포트, 주입
public class DollarCalculatorTest {

    @MockBean   // Mocking 처리 (Spring에서 빈으로 관리되기 때문에 @MockBean임)
    private MarketApi marketApi;

    @Autowired
    private Calculator calculator;

    @Test
    public void dollarCalculatorTest() {
        Mockito.when(marketApi.connect()).thenReturn(3000);

        int sum = calculator.sum(10, 10);
        int minus = calculator.minus(10, 10);

        Assertions.assertEquals(60000, sum);
        Assertions.assertEquals(0, minus);
    }
}
