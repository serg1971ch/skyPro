package ru.otus.hw28datajdbc.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.otus.hw28datajdbc.dtos.PageDtoPagination;
import ru.otus.hw28datajdbc.entities.Book;
import ru.otus.hw28datajdbc.entities.Category;
import ru.otus.hw28datajdbc.entities.Page;


import java.util.List;

@Repository
public interface BookPaginationRepository extends CrudRepository<Page, Long> {
//    @Query("SELECT COUNT(*) FROM BOOKS")
//    int countBooks();

    @Query(
      "select size,count from PAGES where book_id = 1"
    )
    PageDtoPagination getPageDto();
}
