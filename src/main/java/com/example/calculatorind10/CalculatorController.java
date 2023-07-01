package com.example.calculatorind10;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return calculatorService.greetings();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        String result = Integer.toString(calculatorService.plus(num1, num2));
        return getResult(num1, num2, "+", result);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        String result = Integer.toString(calculatorService.minus(num1, num2));
        return getResult(num1, num2, "-", result);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        String result = Integer.toString(calculatorService.multiply(num1, num2));
        return getResult(num1, num2, "*", result);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "На ноль делить нельзя!";
        }

        String result = Double.toString(calculatorService.divide(num1, num2));
        return getResult(num1, num2, "/", result);
    }

    private String getResult(int num1, int num2, String operation, String result) {
        return String.format("%s %s %s = %s", num1, operation, num2, result);
    }
}
