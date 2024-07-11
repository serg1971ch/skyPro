package org.example.exceptions;

public class InvalidIndexException extends IllegalArgumentException {
    public InvalidIndexException(String message) {
        super(message);
    }
}
