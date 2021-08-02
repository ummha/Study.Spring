package com.example.calculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // private final 로 안하니깐 테스트할때 널됨
public class DollarCalculator implements ICalculator {
    private int price = 1;
    private final MarketApi marketApi;

    @Override
    public void init() {
        this.price = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x *= this.price;
        y *= this.price;

        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= this.price;
        y *= this.price;

        return x - y;
    }
}
