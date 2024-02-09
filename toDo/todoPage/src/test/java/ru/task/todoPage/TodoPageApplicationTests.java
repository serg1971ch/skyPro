package ru.task.todoPage;


import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.util.Asserts;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.task.todoPage.model.*;
import ru.task.todoPage.repository.ToDoDaoImpl;
import ru.task.todoPage.repository.ToDoPageRepository;
import ru.task.todoPage.service.ToDoPageService;

import java.util.*;

import static org.junit.Assert.assertNotNull;

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
		User user = new User(1,"Vovan", true);
		Message message = new Message(1,"it is needing to refine first task",user);
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
		User user = new User(1,"Vovan", true);
		Message message = new Message(1,"it is needing to refine first task",user);
		List<Message> messageList = new ArrayList<Message>();
		messageList.add(message);
		Task task = new Task("first task", "to do first task", State.PROCESS, Importance.MIDDLE, messageList);
        service.findAll();
//		repository.create(task);
	}


}
