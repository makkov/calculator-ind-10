package com.example.calculatorind10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceParametrizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    public static Stream<Arguments> plusParams() {
        return Stream.of(
                Arguments.of(1, 1, "1 + 1 = 2"),
                Arguments.of(89, 4, "89 + 4 = 93"),
                Arguments.of(777, 13, "777 + 13 = 790")
        );
    }

    @ParameterizedTest
    @MethodSource("plusParams")
    void plus(int num1, int num2, String result) {
        assertEquals(result, calculatorService.plus(num1, num2));
    }

    public static Stream<Arguments> minusParams() {
        return Stream.of(
                Arguments.of(1, 1, "1 - 1 = 0"),
                Arguments.of(89, 4, "89 - 4 = 85"),
                Arguments.of(777, 13, "777 - 13 = 764")
        );
    }

    @ParameterizedTest
    @MethodSource("minusParams")
    void minus(int num1, int num2, String result) {
        assertEquals(result, calculatorService.minus(num1, num2));
    }

    public static Stream<Arguments> multiplyParams() {
        return Stream.of(
                Arguments.of(1, 1, "1 * 1 = 1"),
                Arguments.of(8, 4, "8 * 4 = 32"),
                Arguments.of(777, 0, "777 * 0 = 0")
        );
    }

    @ParameterizedTest
    @MethodSource("multiplyParams")
    void multiply(int num1, int num2, String result) {
        assertEquals(result, calculatorService.multiply(num1, num2));
    }

    public static Stream<Arguments> divideParams() {
        return Stream.of(
                Arguments.of(1, 1, "1 / 1 = 1.0"),
                Arguments.of(8, 2, "8 / 2 = 4.0"),
                Arguments.of(222, 111, "222 / 111 = 2.0")
        );
    }

    @ParameterizedTest
    @MethodSource("divideParams")
    void divide(int num1, int num2, String result) {
        assertEquals(result, calculatorService.divide(num1, num2));
    }
}