package ru.otus.hw28datajdbc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.*;

@Table("BOOKS")
public class Book {
    @Id
    private Long id;
    private String title;
    @MappedCollection(idColumn = "BOOK_ID")
    private Page pages;

    @PersistenceCreator
    public Book(Long id, String title, Page pages) {
        this.id = id;
        this.title = title;
        this.pages = pages;
    }

    public void setPages(Page pages) {
        this.pages = pages;
    }

    public Page getPages() {
        return pages;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
