package ru.skyProl.hogwarts_streams.exceptions;

public class StudentNotFoundException extends RuntimeException {
    private long id;

    public StudentNotFoundException(long studentId) {
        this.id = studentId;
    }

    public long getId() {
        return id;
    }
}
