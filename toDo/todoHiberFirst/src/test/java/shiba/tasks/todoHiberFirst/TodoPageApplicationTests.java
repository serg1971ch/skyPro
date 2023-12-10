package shiba.tasks.todoHiberFirst;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import shiba.tasks.todoHiberFirst.model.*;
import shiba.tasks.todoHiberFirst.repository.ToDoDao;
import java.util.*;

@DisplayName("Репозиторий Tasks должен")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(ToDoDao.class)
class TodoPageApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger("LoggerTestRepository");

    private final ToDoDao dao;
    @Autowired
    private TestEntityManager em;

    @Autowired
    TodoPageApplicationTests(ToDoDao dao) {
        this.dao = dao;
    }

//    @BeforeEach
//    void setUp() {
//		User user = new User("Vovan", true);
//		Message message = new Message("it is needing to refine first task",user);
//		List<Message> messageList = new ArrayList<Message>();
//		messageList.add(message);
//		Task task = new Task("first task", "to do first task", State.PROCESS, Importance.MIDDLE, messageList);
//    }

    @Test
    void contextLoads() {
    }

    @DisplayName("сохранение объекта по базе h2")
    @Test
    void saveTask() {
        User user = new User("Vovan", true);
        Message message = new Message("it is needing to refine first task",user);
        List<Message> messageList = new ArrayList<Message>();
        messageList.add(message);
        Task task = new Task("first task", "to do first task", State.PROCESS, Importance.MIDDLE, messageList);

        dao.save(task);

//		repository.create(task);
    }


}
