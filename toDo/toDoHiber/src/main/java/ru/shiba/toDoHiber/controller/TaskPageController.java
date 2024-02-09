package ru.shiba.toDoHiber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shiba.toDoHiber.model.Task;
import ru.shiba.toDoHiber.service.ToDoPageService;


import java.util.List;
@RestController
public class TaskPageController {
    private final ToDoPageService pageService;
    @Autowired
    public TaskPageController(@Qualifier("toDoPageService") ToDoPageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/tasks")
    List<Task> findAll(){
        return pageService.findAll();
    }
}
