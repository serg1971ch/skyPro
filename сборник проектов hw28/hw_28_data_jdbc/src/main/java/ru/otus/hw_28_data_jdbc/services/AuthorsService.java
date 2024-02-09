package ru.otus.hw_28_data_jdbc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.hw_28_data_jdbc.entities.Author;
import ru.otus.hw_28_data_jdbc.repositories.AuthorsRepository;
//import ru.flamexander.spring.data.jdbc.demo.entities.Author;
//import ru.flamexander.spring.data.jdbc.demo.repositories.AuthorsRepository;

import java.util.Optional;

@Service
public class AuthorsService {
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public Optional<Author> findById(@PathVariable Long id) {
        return authorsRepository.findById(id);
    }
}
