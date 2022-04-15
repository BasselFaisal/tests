package com.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {

    CalculatorService calculatorService;

    @Test
    public void testMultiply(){
        calculatorService = new CalculatorService();
        assertEquals(20, calculatorService.multiply(2, 10));
    }
}
