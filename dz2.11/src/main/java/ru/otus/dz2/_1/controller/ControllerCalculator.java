package ru.otus.dz2._1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.dz2._1.service.OperationsCalculatorServiceImpl;

@RestController
public class ControllerCalculator {

    private final OperationsCalculatorServiceImpl service;

    public ControllerCalculator(OperationsCalculatorServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String getTitle() {
        return "<h1 align='center'>Добро пожаловать в калькулятор</h1>";
    }

    @GetMapping(value = "/add")
    public int add(@RequestParam int first, @RequestParam int second) {
        return service.add(first, second);
    }

    @GetMapping(value = "/minus")
    public int minus (@RequestParam int first, @RequestParam int second) {
        return service.minus(first, second);
    }

    @GetMapping(value = "/multiply")
    public int multiply (@RequestParam int first, @RequestParam int second) {
        return service.multiply(first, second);
    }

    @GetMapping(value = "/divide")
    public int divide (@RequestParam int first, @RequestParam int second) {
        return service.divide(first, second);
    }
}
