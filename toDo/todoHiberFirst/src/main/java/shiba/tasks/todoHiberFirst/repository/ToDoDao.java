package shiba.tasks.todoHiberFirst.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shiba.tasks.todoHiberFirst.model.Task;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoDao extends CrudRepository<Task, Long> {
//    List<Task> findAll();
//
//    Optional<Task> findByName(String s);
//    Object save(Task task);
}
