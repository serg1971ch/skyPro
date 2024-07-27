package ru.skypro.dz3_3.exceptions;

public class NotFoundException extends RuntimeException{

    private long id;

    public NotFoundException(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
