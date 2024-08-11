package ru.skypro.hogwarts.exceptions;

public class FacultyAlreadyAddedException extends RuntimeException {
    public FacultyAlreadyAddedException(String message) {
        super(message);
    }
}
