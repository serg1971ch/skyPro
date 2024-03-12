package ru.otus.hw30march.model;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(name="book_id_seq", initialValue = 100, allocationSize = 100)
public class Book {

    public Long id;

    public String title;

    public Boolean booked;


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "book_id_seq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "title")
    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    @Column(name = "booked")
    public Boolean isBooked() {
        return booked != null ? booked : false;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }
}