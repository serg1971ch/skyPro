package ru.otus.hw_28_data_jdbc.dtos;

//import ru.flamexander.spring.data.jdbc.demo.entities.Genre;

import ru.otus.hw_28_data_jdbc.entities.Genre;

public class DetailedBookDto {
    private Long id;
    private String title;
    private Genre genre;
    private String authorName;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DetailedBookDto() {
    }
}