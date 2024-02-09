package ru.otus.webbook.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.webbook.repositories.TableBookRepository;


@RestController
public class BookController {

    private final TableBookRepository repository;

    @Autowired
    public BookController(TableBookRepository repository) {
        this.repository = repository;
    }

//    @GetMapping("/")
//    public List<Book> getBook() {
//        return repository.findAll();
//    }

    @GetMapping("/")
    public String show(Model model) {
//        нужно найти через репозитороий сколько книг в базе данных
//        int count = repository.returnCountBook();
//        String stroke = String.valueOf(count);
//        model.addAttribute("count", count);
        return "index";
    }
}
