package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Spring Test 코드 작성시 유의사항은
 * 같은 package 내에서 테스트 코드를 작성해야한다.
 * ex)
 * src/main/java/com/example/calculator/CalculatorApplication
 * src/test/java/com/example/calculator/CalculatorApplication
 */
@SpringBootTest
class CalculatorApplicationTests {

    @Test
    void contextLoads() {
    }

}
