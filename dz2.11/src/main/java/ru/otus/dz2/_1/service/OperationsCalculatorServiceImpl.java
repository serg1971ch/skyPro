package ru.otus.dz2._1.service;

import org.springframework.stereotype.Service;
import ru.otus.dz2._1.Calculator;

@Service
public class OperationsCalculatorServiceImpl implements OpetrationsCalculator{

    private final Calculator calculator;

    public OperationsCalculatorServiceImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int a, int b) {
        return calculator.add(a, b);
    }

    @Override
    public int minus(int a, int b) {
        return calculator.minus(a, b);
    }

    @Override
    public int multiply(int a, int b) {
        return calculator.multiply(a, b);
    }

    @Override
    public int divide(int a, int b) {
        return calculator.divide(a, b);
    }
}
