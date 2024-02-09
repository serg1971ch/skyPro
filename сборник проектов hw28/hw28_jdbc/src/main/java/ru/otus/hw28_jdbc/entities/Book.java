package ru.otus.hw28_jdbc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("BOOKS")
public class Book {
    @Id
    private Long id;
    private String title;


    @PersistenceCreator
    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
