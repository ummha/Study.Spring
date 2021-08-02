package com.example.calculator.controller;

import com.example.calculator.component.Calculator;
import com.example.calculator.component.ICalculator;
import com.example.calculator.dto.Req;
import com.example.calculator.dto.Res;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiCalculatorController {

    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x,@RequestParam int y) {
        return calculator.sum(x, y);
    }

    @PostMapping("/minus")
    public Res minus(@RequestBody Req req) {
        int result = calculator.minus(req.getX(), req.getY());

        Res res = new Res();
        res.setResult(result);
        res.setResponse(new Res.Body());

        return res;
    }
}
