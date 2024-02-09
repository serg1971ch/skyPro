package ru.otus.hw28_jdbc.repositories;

import org.springframework.data.repository.ListCrudRepository;
import ru.otus.hw28_jdbc.entities.Book;

public interface TableBookRepository extends ListCrudRepository<Book, Long> {
}
