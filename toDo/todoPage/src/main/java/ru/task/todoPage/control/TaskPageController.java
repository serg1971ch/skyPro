package ru.task.todoPage.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;
import ru.task.todoPage.model.Task;
import ru.task.todoPage.service.ToDoPageService;
import java.util.*;
@RestController
public class TaskPageController {
    private final ToDoPageService pageService;
    @Autowired
    public TaskPageController(ToDoPageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/tasks")
    List<Task> findAll(){
        return pageService.findAll();
    }
}
