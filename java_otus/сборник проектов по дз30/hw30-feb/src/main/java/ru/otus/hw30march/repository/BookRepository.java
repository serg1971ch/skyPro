package ru.otus.hw30march.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw30march.model.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
      Book getBooksById(long id);
}
