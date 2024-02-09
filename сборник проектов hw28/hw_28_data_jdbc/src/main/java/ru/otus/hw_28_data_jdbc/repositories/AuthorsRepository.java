package ru.otus.hw_28_data_jdbc.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw_28_data_jdbc.entities.Author;


@Repository
public interface AuthorsRepository extends ListCrudRepository<Author, Long> {
}