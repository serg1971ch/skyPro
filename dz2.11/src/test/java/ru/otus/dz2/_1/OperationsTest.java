package ru.otus.dz2._1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.dz2._1.service.OperationsCalculatorServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    private static final int FIRST_NUMBER = 1;
    private static final int SECOND_NUMBER = 2;
    private static final int THIRD_NUMBER = 3;
    private static final int FOURTH_NUMBER = 4;
    private static final int FIFTH_NUMBER = 5;
    private static final int SIXTH_NUMBER = 6;
    private static final int SEVEN_NUMBER = 15;
    private static final int RESULT_PLUS = 3;
    private static final int RESULT_MINUS = 2;
    private static final int RESULT_TIMES = 12;
    private static final int RESULT_DIVIDE = 3;
    private final Calculator calculator = new Calculator(1,1);
    private final OperationsCalculatorServiceImpl service = new OperationsCalculatorServiceImpl(calculator);

    public static Stream<Arguments> provideParamsForAddTest() {
        return Stream.of(Arguments.of(FIRST_NUMBER, SECOND_NUMBER, RESULT_PLUS)
        );
    }

    public static Stream<Arguments> provideParamsForMinusTest() {
        return Stream.of(Arguments.of(FOURTH_NUMBER, SECOND_NUMBER, RESULT_MINUS)
        );
    }

    public static Stream<Arguments> provideParamsForTimesTest() {
        return Stream.of(Arguments.of(SIXTH_NUMBER, SECOND_NUMBER, RESULT_TIMES)
        );
    }

    public static Stream<Arguments> provideParamsForDivideTest() {
        return Stream.of(Arguments.of(Arguments.of(SEVEN_NUMBER, FIFTH_NUMBER, RESULT_DIVIDE))
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddTest")
    public void shouldGenerateCorrectAddOperationResult(int firstNumber, int secondNumber, int result) {
        int resultService = service.add(firstNumber, secondNumber);
        assertEquals(resultService, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinusTest")
    public void shouldGenerateCorrectMinusOperationResult(int firstNumber, int secondNumber, int result) {
        int resultService = service.minus(firstNumber, secondNumber);
        assertEquals(resultService, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTimesTest")
    public void shouldGenerateCorrectTimesOperationResult(int firstNumber, int secondNumber, int result) {
        int resultService = service.multiply(firstNumber, secondNumber);
        assertEquals(resultService, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivideTest")
    public void shouldGenerateCorrectDivideOperationResult(int firstNumber, int secondNumber, int result) {
        Integer resultService = service.divide(firstNumber, secondNumber);
        assertEquals(resultService, result);
    }
}
