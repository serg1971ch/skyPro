package ru.skypro.dz27.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
