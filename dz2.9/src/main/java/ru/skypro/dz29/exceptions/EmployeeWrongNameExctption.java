package ru.skypro.dz29.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeWrongNameExctption extends RuntimeException{
    public EmployeeWrongNameExctption(String message) {
        super(message);
    }
}
