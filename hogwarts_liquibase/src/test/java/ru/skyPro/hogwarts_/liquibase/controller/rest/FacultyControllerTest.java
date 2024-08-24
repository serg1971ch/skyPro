package ru.skyPro.hogwarts_.liquibase.controller.rest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import ru.skyPro.hogwarts_.liquibase.model.Faculty;
import ru.skyPro.hogwarts_.liquibase.model.Student;
import ru.skyPro.hogwarts_.liquibase.repository.FacultyRepository;
import ru.skyPro.hogwarts_.liquibase.service.FacultyService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacultyControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private FacultyService facultyService;

//    @BeforeEach
//    public void setUp() {
//        // Очистка базы данных перед каждым тестом
//        facultyRepository.deleteAll();
//    }

//    @Test
//    public void createFaculty() {
//        Faculty faculty = new Faculty(null, "Engineering", "Blue");
//        ResponseEntity<Faculty> response = restTemplate.postForEntity("/faculty", faculty, Faculty.class);
//
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        Faculty createdFaculty = response.getBody();
//        assertThat(createdFaculty).isNotNull();
//        assertThat(createdFaculty.getId()).isNotNull();
//
//        Faculty facultyFromDb = facultyRepository.findById(createdFaculty.getId()).orElse(null);
//        assertThat(facultyFromDb).isNotNull();
//        assertThat(facultyFromDb.getName()).isEqualTo("Engineering");
//        assertThat(facultyFromDb.getColor()).isEqualTo("Blue");
//    }

//    @Test
//    public void updateFaculty() {
//        Faculty faculty = new Faculty(1L, "Engineering", "Blue");
//
//        HttpEntity<Faculty> facultyHttpEntity = new HttpEntity<>(faculty);
//        ResponseEntity<Faculty> response = restTemplate.exchange("/faculty/" + faculty.getId(), HttpMethod.PUT, facultyHttpEntity, Faculty.class);
//
//        Assertions.assertEquals(response.getStatusCode(), HttpStatusCode.valueOf(200));
//        Faculty updatedFaculty = facultyRepository.findById(faculty.getId()).orElse(null);
//        assertThat(updatedFaculty).isNotNull();
//        assertThat(updatedFaculty.getName()).isEqualTo("Engineering Updated");
//        assertThat(updatedFaculty.getColor()).isEqualTo("Red");
//    }

    @Test
    public void getFaculty() {
        Faculty faculty = new Faculty(null, "Engineering", "Blue");
        faculty = facultyRepository.save(faculty);

        ResponseEntity<Faculty> response = restTemplate.getForEntity("/faculty/" + faculty.getId(), Faculty.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Faculty fetchedFaculty = response.getBody();
        assertThat(fetchedFaculty).isNotNull();
        assertThat(fetchedFaculty.getId()).isEqualTo(faculty.getId());
        assertThat(fetchedFaculty.getName()).isEqualTo("Engineering");
        assertThat(fetchedFaculty.getColor()).isEqualTo("Blue");
    }

//    @Test
//    public void remove() {
//        restTemplate.delete("/faculty/1");
//        ResponseEntity<Faculty> getResponse = restTemplate.getForEntity("/faculty/1", Faculty.class);
//        assertThat(getResponse.getStatusCodeValue()).isEqualTo(404);
//    }

    @Test
    public void wouldFilterByColor() {
        Faculty faculty1 = new Faculty("Gryffindor", "Red");
        Faculty faculty2 = new Faculty("Slytherin", "Green");

        facultyRepository.save(faculty1);
        facultyRepository.save(faculty2);

        ResponseEntity<Faculty[]> response = restTemplate.getForEntity("/faculty?color=Red", Faculty[].class);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);

        Faculty[] filteredFaculties = response.getBody();
        assertThat(filteredFaculties).isNotNull();
        assertThat(filteredFaculties.length).isEqualTo(1);
        assertThat(filteredFaculties[0].getName()).isEqualTo("Gryffindor");
        assertThat(filteredFaculties[0].getColor()).isEqualTo("Red");
    }

//    @Test
//    public void wouldFilterByColorOrName() {
//        Faculty faculty1 = new Faculty("Gryffindor", "Red");
//        Faculty faculty2 = new Faculty("Slytherin", "Green");
//        Faculty faculty3 = new Faculty("Slytherin", "Green");
//
//        facultyRepository.save(faculty1);
//        facultyRepository.save(faculty2);
//        facultyRepository.save(faculty3);
//
//        ResponseEntity<Faculty[]> response = restTemplate.getForEntity("/faculty?color=Green&name=Slytherin", Faculty[].class);
//
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//
//        Faculty[] filteredFaculties = response.getBody();
//        assertThat(filteredFaculties).isNotNull();
//        assertThat(filteredFaculties.length).isEqualTo(2);
//        assertThat(filteredFaculties[0].getName()).isEqualTo("Slytherin");
//        assertThat(filteredFaculties[0].getColor()).isEqualTo("Green");
//        assertThat(filteredFaculties[1].getName()).isEqualTo("Slytherin");
//        assertThat(filteredFaculties[1].getColor()).isEqualTo("Green");
//    }

    @Test
    public void findStudentsByFacultyName() {
        // Создание факультета и сохранение его в базу данных
        ResponseEntity<Faculty> responseFaculty = restTemplate.postForEntity("/faculty", new Faculty("Test Faculty", "Test Color"), Faculty.class);
        assertThat(responseFaculty.getStatusCodeValue()).isEqualTo(200);
        Long facultyId = responseFaculty.getBody().getId();

        // Создание нескольких студентов и сохранение их с привязкой к факультету
        restTemplate.postForEntity("/student", new Student(1L, "Alice", 25, responseFaculty.getBody()), Student.class);
        restTemplate.postForEntity("/student", new Student(2L, "Bob", 30, responseFaculty.getBody()), Student.class);

        // Получение списка студентов для данного факультета
        ResponseEntity<Student[]> responseStudents = restTemplate.getForEntity("/faculty/" + facultyId + "/students", Student[].class);

        // Проверка, что запрос завершился успешно и вернул список студентов
        assertThat(responseStudents.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseStudents.getBody()).isNotNull();
        List<Student> students = List.of(responseStudents.getBody());
        assertThat(students).hasSize(2); // Проверка, что вернулось 2 студента
        assertThat(students.get(0).getName()).isEqualTo("Alice");
        assertThat(students.get(1).getName()).isEqualTo("Bob");
    }
}
