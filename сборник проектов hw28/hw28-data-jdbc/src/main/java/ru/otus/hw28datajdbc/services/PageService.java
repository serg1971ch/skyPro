package ru.otus.hw28datajdbc.services;

import org.springframework.stereotype.Service;
import ru.otus.hw28datajdbc.entities.Page;
import ru.otus.hw28datajdbc.repositories.BookPaginationRepository;

import java.util.List;

@Service
public class PageService {
    private final BookPaginationRepository repository;

    public PageService(BookPaginationRepository repository) {
        this.repository = repository;
    }

    public List<Page> findAll() {
        return (List<Page>) repository.findAll();
    }
}
