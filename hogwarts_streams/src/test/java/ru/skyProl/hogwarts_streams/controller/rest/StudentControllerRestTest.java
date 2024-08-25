package ru.skyProl.hogwarts_streams.controller.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import ru.skyProl.hogwarts_streams.model.Faculty;
import ru.skyProl.hogwarts_streams.model.Student;
import ru.skyProl.hogwarts_streams.repository.AvatarRepository;
import ru.skyProl.hogwarts_streams.repository.FacultyRepository;
import ru.skyProl.hogwarts_streams.repository.StudentRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerRestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private AvatarRepository avatarRepository;


    Faculty faculty1 = new Faculty("red", "Gryffindor");
    Faculty faculty2 = new Faculty("black", "Hufflepuff");
    Faculty faculty3 = new Faculty("blue", "Ravenclaw");
    Student student1 = new Student(1L, "Alex", 23, faculty1);
    Student student2 = new Student(2L, "Pete", 22, faculty1);
    Student student3 = new Student(3L, "Lucy", 20, faculty1);
    Student student4 = new Student(4L, "Mike", 24, faculty2);
    Student student5 = new Student(5L, "Tony", 20, faculty2);
    Student student6 = new Student(6L, "Elizabeth", 18, faculty2);
    Student student7 = new Student(7L, "Andre", 25, faculty3);
    Student student8 = new Student(8L, "William", 24, faculty3);
    Student student9 = new Student(9L, "Simon", 21, faculty3);
    Student student10 = new Student(10L, "Victor", 20, faculty3);
    File fi = new File("C:\\Users\\Honor\\Desktop\\hogwarts\\hogwarts\\src\\test\\resources\\image\\avatar1.jpg");

    public StudentControllerRestTest() throws IOException {
    }

    @BeforeEach
    void setUp() {
        facultyRepository.save(faculty1);
        facultyRepository.save(faculty2);
        facultyRepository.save(faculty3);
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
        studentRepository.save(student7);
        studentRepository.save(student8);
        studentRepository.save(student9);
        studentRepository.save(student10);
    }

    @Test
    void findByAgeStudent() {
        ResponseEntity<Student[]> forEntity = restTemplate.getForEntity("/student/age?age=20", Student[].class);
        Assertions.assertEquals(forEntity.getStatusCode(), HttpStatusCode.valueOf(200));
        Assertions.assertEquals(Objects.requireNonNull(forEntity.getBody()).length, 3);
    }

    @Test
    void createStudent() {
        Student student11 = new Student(11L, "John", 28, faculty1);
        ResponseEntity<Student> forEntityStudent11 = restTemplate.postForEntity("/student", student11, Student.class);
        Assertions.assertEquals(forEntityStudent11.getStatusCode(), HttpStatusCode.valueOf(200));
        assertThat(forEntityStudent11.getBody()).isNotNull();
    }

//    @Test
//    void testUpdateStudent() {
//        Student student = studentRepository.findAll().get(0);
//        student.setName("Johnny");
//        HttpEntity<Student> studentHttpEntity = new HttpEntity<>(student);
//        ResponseEntity<Student> responseUpdate = restTemplate.exchange("/student/" + student.getId(), HttpMethod.PUT, studentHttpEntity, Student.class);
//        Assertions.assertEquals(responseUpdate.getStatusCode(), HttpStatusCode.valueOf(200));
//        assertThat(studentRepository.findById(student.getId()).get().getName()).isEqualTo("Johnny");
//    }

    @Test
    void testGetStudent() {
        Student student = studentRepository.findAll().get(0);
        ResponseEntity<Student> response = restTemplate.getForEntity("http://localhost:" + port + "/student/" + student.getId(), Student.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getName()).isEqualTo(student.getName());
    }

    @Test
    void testDeleteStudent() {
        Student student = studentRepository.findAll().get(0);
        restTemplate.delete("http://localhost:" + port + "/student/" + student.getId());
        assertThat(studentRepository.findById(student.getId())).isEmpty();
    }

    @DisplayName("должен студентов по их минимальному и максимальному возрасту")
    @Test
    void wouldFilterStudentsByAge() {
        ResponseEntity<List<Student>> forEntity = restTemplate.exchange("/student/age-range?minAge=23&maxAge=25", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Student>>() {

                });
        assertThat(forEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(forEntity.getBody()).isNotNull();
    }

//    @Test
//    void testFindStudentByFaculty() {
//        ResponseEntity<Faculty> response = restTemplate.getForEntity("/student/1/faculty", Faculty.class);
//        assertThat(response.getBody()).isNotNull();
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//    }

//    @Test
//    @DisplayName("должен аватар студентов по базе данных")
//    void testGetAvatarFromDB() {
//        ResponseEntity<Avatar> response = restTemplate.getForEntity("/student/1/get-avatar-from-db", Avatar.class);
//        assertThat(response.getBody()).isNotNull();
//        assertThat(response.getStatusCode().value()).isEqualTo(200);
//    }

//    @Test
//    void testGetAvatarFromFS() {
//        ResponseEntity<byte[]> response = restTemplate.getForEntity("/student/1/get-avatar-from-fs", byte[].class);
//        assertThat(response.getBody()).isNotNull();
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//    }

    @Test
    void testCountAllStudents() {
        ResponseEntity<Long> forEntityList = restTemplate.getForEntity("/student/count", Long.class);
        assertThat(forEntityList.getStatusCodeValue()).isEqualTo(200);
        assertThat(forEntityList.getBody()).isNotNull();
        assertThat(forEntityList.getBody()).isEqualTo(studentRepository.findAll().size());
    }

    @Test
    void testAverageStudents() {
        ResponseEntity<Integer> forEntityList = restTemplate.getForEntity("/student/average", Integer.class);
        assertThat(forEntityList.getStatusCodeValue()).isEqualTo(200);
        assertThat(forEntityList.getBody()).isNotNull();
    }

    @Test
    void findLastFiveStudents() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/student/last-5", String.class);

        Assertions.assertEquals(HttpStatusCode.valueOf(200), responseEntity.getStatusCode());

        String students = responseEntity.getBody();

        assertThat(students).isNotNull();
        assertThat(students).hasSizeLessThanOrEqualTo(5);
    }
}



