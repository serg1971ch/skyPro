package ru.task.todoPage.repository;

import lombok.SneakyThrows;
//import org.flywaydb.core.internal.jdbc.JdbcTemplate;
//import org.flywaydb.core.internal.jdbc.RowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.task.todoPage.model.Importance;
import ru.task.todoPage.model.State;
import ru.task.todoPage.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Component
public class ToDoDaoImpl implements ToDoDao<Task>{

    private static final Logger log = LoggerFactory.getLogger(ToDoDaoImpl.class);
    private JdbcTemplate jdbcTemplate;

    public ToDoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Maps a row in the database to a Course
     */
    RowMapper<Task> rowMapper = (rs,rowNum) -> {
        Task task = new Task();
        task.setId(rs.getInt("id"));
        task.setNameTask(rs.getString("name_task"));
        task.setDescriptionTask(rs.getString("name_description"));
        task.setState(State.valueOf(rs.getString("state")));
        task.setImportance(Importance.valueOf(rs.getString("importance")));
        return task;
    };
    @Override
    public List<Task> list() {
        return null;
    }

    @Override
    public void create(Task task) {
//        String sql = "insert into tasks(1,name_task,name_description,state, importance) values(?,?,?,?)";
//        int insert  = jdbcTemplate.update(sql,task.getNameTask(),task.getDescriptionTask(),task.getState(),task.getImportance());
//        if(insert == 1) {
//            log.info("New Course Created: " + task.getNameTask());
//        }
    }

    @Override
    public Optional<Task> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Task task, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
