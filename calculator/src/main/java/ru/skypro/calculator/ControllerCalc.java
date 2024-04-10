package ru.skypro.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCalc {
    private final CalculatorImpl calculator;

    public ControllerCalc(CalculatorImpl calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/")
    public String greeting() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("sum")
    public String sum(@RequestParam("num1") Integer number1, @RequestParam("num2") Integer number2) {
        emptyArguments(number1, number2);
        String fist = String.valueOf(number1);
        String second = String.valueOf(number2);
        return fist + "+ " + second + " = " + calculator.sum(number1, number2);
    }

    @GetMapping("minus")
    public String minus(@RequestParam("num1") Integer number1, @RequestParam("num2") Integer number2) {
        emptyArguments(number1, number2);
        String fist = String.valueOf(number1);
        String second = String.valueOf(number2);
        return fist + " - " + second + " = " + calculator.minus(number1, number2);
    }

    @GetMapping("multiply")
    public String multyply(@RequestParam("num1") Integer number1, @RequestParam("num2") Integer number2) {
        emptyArguments(number1, number2);
        String fist = String.valueOf(number1);
        String second = String.valueOf(number2);
        return fist + " * " + second + " = " + calculator.multшply(number1, number2);
    }

    @GetMapping("divide")
    public String multiply(@RequestParam("num1") Integer number1, @RequestParam("num2") Integer number2) {
        emptyArguments(number1, number2);
        String fist = String.valueOf(number1);
        String second = String.valueOf(number2);
        return fist + " / " + second + " = " + calculator.devide(number1, number2);
    }

    public void emptyArguments(Integer number1, Integer number2) {
        if ((number1 == null) || (number2 == null)) {
            throw new IllegalArgumentException("arguments of mapping are null");
        }
    }
}
