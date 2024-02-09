package ru.otus.webbook.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import ru.otus.webbook.entities.Book;


public interface TableBookRepository extends ListCrudRepository<Book, Long> {
//    @Query("select count(*) from books")
//    int returnCountBook();
}
