package ru.otus.hw28_jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw28_jdbc.entities.Book;
import ru.otus.hw28_jdbc.repositories.TableBookRepository;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final TableBookRepository repository;
    @Autowired
    public BookController(TableBookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Book> getBook() {
        return repository.findAll();
    }
}
