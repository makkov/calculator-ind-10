package com.example.calculatorind10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void greetings_success() {
        //Подготовка ожидаемого результата
        String expectedResult = "Добро пожаловать в калькулятор!";

        //Начало теста
        String actualResult = calculatorService.greetings();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void plus_success() {
        //Подготовка входных данных
        int num1 = 4;
        int num2 = 2;

        //Подготовка ожидаемого результата
        String expectedResult = TestUtils.formatResult(num1, num2, "+", "6");

        //Начало теста
        String actualResult = calculatorService.plus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void plus_success2() {
        //Подготовка входных данных
        int num1 = 8;
        int num2 = 15;

        //Подготовка ожидаемого результата
        String expectedResult = TestUtils.formatResult(num1, num2, "+", "23");

        //Начало теста
        String actualResult = calculatorService.plus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void minus_success() {
        //Подготовка входных данных
        int num1 = 4;
        int num2 = 2;

        //Подготовка ожидаемого результата
        String expectedResult = TestUtils.formatResult(num1, num2, "-", "2");

        //Начало теста
        String actualResult = calculatorService.minus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void multiply_success() {
        //Подготовка входных данных
        int num1 = 4;
        int num2 = 2;

        //Подготовка ожидаемого результата
        String expectedResult = TestUtils.formatResult(num1, num2, "*", "8");

        //Начало теста
        String actualResult = calculatorService.multiply(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void divide_success() {
        //Подготовка входных данных
        int num1 = 4;
        int num2 = 2;

        //Подготовка ожидаемого результата
        String expectedResult = TestUtils.formatResult(num1, num2, "/", "2.0");

        //Начало теста
        String actualResult = calculatorService.divide(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void divide_withNum2IsZero() {
        //Подготовка входных данных
        int num1 = 4;
        int num2 = 0;

        //Подготовка ожидаемого результата
        String expectedErrorMessage = "На ноль делить нельзя!";

        //Начало теста
        Exception exception = assertThrows(ZeroDivideException.class, () -> calculatorService.divide(num1, num2));
        assertEquals(expectedErrorMessage, exception.getMessage());
    }
}