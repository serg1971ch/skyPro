package ru.skypro.kursovaya2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAreEmptyException extends RuntimeException{
    public QuestionAreEmptyException(String message) {
        super(message);
    }
}
