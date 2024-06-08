package ru.otus.dz2._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator(0, 0);
    }

    @Test
    public void testAdd() {
        Assertions.assertEquals(5, calculator.add(2, 3));
        Assertions.assertEquals(0, calculator.add(-1, 1));
    }

    @Test
    public void testMinus() {
        Assertions.assertEquals(5, calculator.minus(10, 5));
        Assertions.assertEquals(3, calculator.minus(-1, -4));
    }

    @Test
    public void testMultiply() {
        Assertions.assertEquals(25, calculator.multiply(5, 5));
        Assertions.assertEquals(100, calculator.multiply(10, 10));
    }

    @Test
    public void testDivide() {
        Assertions.assertEquals(5, calculator.divide(15, 3));
        Assertions.assertEquals(1, calculator.divide(3, 3));
    }

    @Test
    public void testDivideByZero() {
        DivisionByZeroException exception = Assertions.assertThrows(DivisionByZeroException.class, () -> {
            calculator.divide(1, 0);
        });
        Assertions.assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}
