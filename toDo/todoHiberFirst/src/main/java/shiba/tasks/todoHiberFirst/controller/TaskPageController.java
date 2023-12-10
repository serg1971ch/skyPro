package shiba.tasks.todoHiberFirst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shiba.tasks.todoHiberFirst.model.Task;
import shiba.tasks.todoHiberFirst.repository.ToDoDao;

import java.util.List;

@RestController
public class TaskPageController {
    private final ToDoDao dao;

    @Autowired
    public TaskPageController(ToDoDao dao) {
        this.dao = dao;
    }


    @GetMapping("/tasks")
    List<Task> findAll() {
        return (List<Task>) dao.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}
