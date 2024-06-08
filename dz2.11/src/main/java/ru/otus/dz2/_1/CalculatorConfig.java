package ru.otus.dz2._1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfig {

    @Bean
    public Calculator calculator() {
        // Предположим, что начальные значения для a и b равны 0
        return new Calculator(0, 0);
    }
}