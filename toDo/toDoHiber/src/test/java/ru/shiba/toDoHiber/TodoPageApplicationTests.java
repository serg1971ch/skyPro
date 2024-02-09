package ru.shiba.toDoHiber;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.shiba.toDoHiber.model.*;
import ru.shiba.toDoHiber.repository.ToDoDaoImpl;
import ru.shiba.toDoHiber.service.ToDoPageService;

import java.util.ArrayList;
import java.util.List;

//@DisplayName("Репозиторий Tasks должен")
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Import(ToDoPageRepository.class)
@DataJdbcTest
//@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class})
class TodoPageApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger("LoggerTestRepository");
    @Autowired
	private ToDoPageService service;
	private JdbcTemplate jdbcTamplate;
	private ToDoDaoImpl repository;

//	@Autowired
//	private TodoPageApplicationTests(JdbcTemplate jdbcTamplate) {
//		this.jdbcTamplate = jdbcTamplate;
//        repository = new ToDoDaoImpl(jdbcTamplate);
//	}

	@BeforeEach
	void setUp() {
		User user = new User("Vovan", true);
		Message message = new Message("it is needing to refine first task",user);
		List<Message> messageList = new ArrayList<Message>();
		messageList.add(message);
		Task task = new Task("first task", "to do first task", State.PROCESS, Importance.MIDDLE, messageList);
	}

	@Test
	void contextLoads() {
	}

	@DisplayName("сохранение объекта по базе h2")
	@Test
	void saveGirls() {
		User user = new User("Vovan", true);
		Message message = new Message("it is needing to refine first task",user);
		List<Message> messageList = new ArrayList<Message>();
		messageList.add(message);
		Task task = new Task("first task", "to do first task", State.PROCESS, Importance.MIDDLE, messageList);
//        service.findAll();
		service.saveTask(task);
//		repository.create(task);
	}


}
