package ru.otus.hw28datajdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//		(exclude = {JdbcTemplateAutoConfiguration.class})
@ComponentScan(basePackages = {"ru.otus.hw28datajdbc.repositories"})
public class Hw28DataJdbcApplication {
	public static void main(String[] args) {
		SpringApplication.run(Hw28DataJdbcApplication.class, args);
	}
}
