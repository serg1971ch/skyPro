package ru.otus.hw28datajdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw28datajdbc.dtos.PageDtoPagination;
import ru.otus.hw28datajdbc.entities.Page;
import ru.otus.hw28datajdbc.services.PageService;

import java.util.*;
import java.util.function.Function;


@RestController
public class BooksPageController {
    private final PageService service;
    private static final Function<Page, PageDtoPagination> MAP_TO_DTO_FUNCTION = c -> new PageDtoPagination(c.getCount());

    @Autowired
    public BooksPageController(PageService service) {
        this.service = service;
    }

    @GetMapping("/page")
    public List<Page> findAll() {
        return service.findAll();
    }
}
