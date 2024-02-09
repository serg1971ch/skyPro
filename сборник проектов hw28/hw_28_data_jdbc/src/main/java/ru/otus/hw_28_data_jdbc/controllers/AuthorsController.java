package ru.otus.hw_28_data_jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw_28_data_jdbc.dtos.AuthorDto;
import ru.otus.hw_28_data_jdbc.entities.Author;
import ru.otus.hw_28_data_jdbc.exceptions.ResourceNotFoundException;
import ru.otus.hw_28_data_jdbc.repositories.AuthorsRepository;


import java.util.function.Function;
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorsController {
//    private final AuthorsService;
    private final AuthorsRepository repository;

    private static final Function<Author, AuthorDto> MAP_TO_DTO_FUNCTION = a -> new AuthorDto(a.getId(), a.getFullName());


//    private static final Function<Author, AuthorDto> MAP_TO_DTO_FUNCTION = a -> new AuthorDto(a.getId(), a.getFullName());

    @Autowired
    public AuthorsController(AuthorsRepository repository) {
        this.repository = repository;
//        this.authorsService = authorsService;
    }



    @GetMapping("/{id}")
    public AuthorDto findById(@PathVariable Long id) {
        return repository.findById(id).map(MAP_TO_DTO_FUNCTION).orElseThrow(() -> new ResourceNotFoundException("Автор не найден"));
    }
}

