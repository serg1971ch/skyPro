package ru.skypro.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements CalculatorInterface {
    @Override
    public Integer sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public Integer minus(int firstSubstract, int secondSubstract) {
        return firstSubstract - secondSubstract;
    }

    @Override
    public Integer multшply(int firstMultiply, int secondMultiply) {
        return firstMultiply * secondMultiply;
    }

    @Override
    public double devide(double firstDevide, int secondDevide) {
        if (secondDevide == 0) {
            System.out.println("На ноль делить нельзя");
            throw new IllegalArgumentException("Java не делит на ноль");
        }
        return firstDevide / secondDevide;
    }
}
