package ru.skyPro.hogwarts_.liquibase.exceptions;

public class FacultyAlreadyAddedException extends RuntimeException {
    public FacultyAlreadyAddedException(String message) {
        super(message);
    }
}
