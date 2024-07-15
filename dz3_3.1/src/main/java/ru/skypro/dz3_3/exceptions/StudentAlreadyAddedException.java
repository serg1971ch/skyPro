package ru.skypro.dz3_3.exceptions;

public class StudentAlreadyAddedException extends RuntimeException {
    public StudentAlreadyAddedException(String message) {
        super(message);
    }
}
