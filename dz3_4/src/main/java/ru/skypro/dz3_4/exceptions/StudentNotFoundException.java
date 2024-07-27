package ru.skypro.dz3_4.exceptions;

public class StudentNotFoundException extends RuntimeException {
    private long id;

    public StudentNotFoundException(long studentId) {
        this.id = studentId;
    }

    public long getId() {
        return id;
    }
}
