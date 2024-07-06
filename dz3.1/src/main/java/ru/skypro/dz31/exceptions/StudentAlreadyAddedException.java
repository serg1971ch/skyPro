package ru.skypro.dz31.exceptions;

public class StudentAlreadyAddedException extends RuntimeException {
    public StudentAlreadyAddedException(String message) {
        super(message);
    }
}
