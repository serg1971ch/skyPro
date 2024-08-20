package ru.skyPro.hogwarts_.liquibase.exceptions;

public class StudentAlreadyAddedException extends RuntimeException {
    public StudentAlreadyAddedException(String message) {
        super(message);
    }
}
