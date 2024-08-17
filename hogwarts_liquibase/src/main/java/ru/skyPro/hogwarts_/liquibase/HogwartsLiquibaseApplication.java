package ru.skyPro.hogwarts_.liquibase;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class HogwartsLiquibaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HogwartsLiquibaseApplication.class, args);
	}

}
