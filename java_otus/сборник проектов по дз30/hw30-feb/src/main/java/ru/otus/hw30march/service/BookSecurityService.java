package ru.otus.hw30march.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw30march.model.Book;
import ru.otus.hw30march.repository.BookRepository;
import java.util.*;

@Service
public class BookSecurityService {

    private BookRepository repository;

    @Autowired
    public BookSecurityService(BookRepository repository) {
        this.repository = repository;
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    public List<Book> getBooks() {
        List<Book> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @Transactional
    public void addBook(String name) {
        Book book = new Book();
        book.setName(name);
        repository.save(book);
    }

    @Transactional
    public void removeBook(Long id) {
        repository.deleteById(Math.toIntExact(id));
    }

    @Transactional
    public void reserveBook(Long id) {
        Optional<Book> book = repository.findById(Math.toIntExact(id));
        if (book.isPresent()) {
            Book entity = book.get();
            entity.setBooked(true);
            repository.save(entity);
        }
    }

    @Transactional
    public void returnBook(Long id) {
        Optional<Book> book = repository.findById(Math.toIntExact(id));
        if (book.isPresent()) {
            Book entity = book.get();
            entity.setBooked(false);
            repository.save(entity);
        }
    }
}
