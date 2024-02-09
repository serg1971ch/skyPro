package shiba.tasks.todoHiberFirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import shiba.tasks.todoHiberFirst.model.*;
import shiba.tasks.todoHiberFirst.repository.ToDoDao;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TodoHiberFirstApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TodoHiberFirstApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(TodoHiberFirstApplication.class);
		ToDoDao toDoRepository = context.getBean(ToDoDao.class);

		User user = new User("Vovan", true);
		Message message = new Message("it is needing to refine first task",user);
		List<Message> messageList = new ArrayList<Message>();
		messageList.add(message);
		Task task = new Task("first task", "to do first task", State.PROCESS, Importance.MIDDLE, messageList);

		toDoRepository.save(task);

	}
}
