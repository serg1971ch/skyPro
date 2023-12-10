package ru.shiba.toDoHiber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shiba.toDoHiber.model.Task;
import ru.shiba.toDoHiber.repository.ToDoDao;
import ru.shiba.toDoHiber.repository.ToDoDaoImpl;

import java.util.List;

@Service
@Transactional
public class ToDoPageServiceImpl implements ToDoPageService{
    private final ToDoDaoImpl dao;
    @Autowired
    public ToDoPageServiceImpl(@Qualifier("toDoDaoImpl") ToDoDaoImpl dao) {
        this.dao = dao;
    }


    @Override
    public void saveServiceTask(Task task) {
        dao.saveTask(task);
    }

    @Override
    public List<Task> findAll() {
        return dao.findAll();
    }
}
