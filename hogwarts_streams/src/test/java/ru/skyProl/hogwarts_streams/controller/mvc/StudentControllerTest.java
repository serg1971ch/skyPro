package ru.skyProl.hogwarts_streams.controller.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.skyProl.hogwarts_streams.controllers.StudentController;
import ru.skyProl.hogwarts_streams.model.Student;
import ru.skyProl.hogwarts_streams.model.Faculty;
import ru.skyProl.hogwarts_streams.repository.StudentRepository;
import ru.skyProl.hogwarts_streams.repository.FacultyRepository;
import ru.skyProl.hogwarts_streams.service.AvatarService;
import ru.skyProl.hogwarts_streams.service.StudentService;


import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    @SpyBean
    private StudentService studentService;

    @MockBean
    private AvatarService avatarService;

    @MockBean
    private FacultyRepository facultyRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Student student;
    private Faculty faculty;

    @BeforeEach
    void setUp() {
        faculty = new Faculty("Slytherin", "green");
        student = new Student(1L, "John", 22, faculty);
    }

    @Test
    public void testCreateStudent() throws Exception {
        Faculty faculty = new Faculty("red", "Gryffindor");
        Student student = new Student(1L, "John", 20, faculty);

        JSONObject joStudent = new JSONObject();
        joStudent.put("name", "John");
        joStudent.put("age", "20");

        JSONObject facultyJo = new JSONObject();
        facultyJo.put("color", "red");
        facultyJo.put("name", "Gryffindor");
        joStudent.put("faculty", facultyJo);

        when(studentRepository.save(any())).thenReturn(student);

        mockMvc.perform(post("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(joStudent)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.name").value(student.getName()))
                .andExpect(jsonPath("$.age").value(student.getAge()));
    }

    @Test
    public void testGetStudentAge() throws Exception {
        when(studentRepository.findByAge(20)).thenReturn(Arrays.asList(new Student("John", 20,faculty), new Student("Mile", 20, faculty)));
        mockMvc.perform(get("/student/age?age=20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }


//    @Test
//    public void testUpdateStudent() throws Exception {
//        JSONObject joStudent = new JSONObject();
//        joStudent.put("name", "John");
//        joStudent.put("age", 20);  // Changed to integer
//        JSONObject facultyJo = new JSONObject();
//        facultyJo.put("color", "green");
//        facultyJo.put("name", "Slytherin");
//        joStudent.put("faculty", facultyJo);
//
//        when(studentService.update(anyLong(), any(Student.class))).thenReturn(student);
//
//        mockMvc.perform(post("/student/{id}", 1L)  // Changed post to put
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(joStudent)))  // Changed this to use toString for JSON object
//                .andExpect(status().isOk());
//    }

    @Test
    public void testDeleteStudent() throws Exception {
        Mockito.doNothing().when(studentService).remove(anyLong());

        mockMvc.perform(delete("/student/{id}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void wouldFilterStudentsByAge() throws Exception {
        Student student = new Student("John", 22, faculty);
        Student student2 = new Student("Mile", 23, faculty);
        Student student3 = new Student("Jane", 24, faculty);

        List<Student> students = Arrays.asList(student, student2, student3);
        List<Student> filteredStudents = studentService.filterByRangeAge(20, 25);

        when(studentRepository.findAllByAgeBetween(anyInt(), anyInt())).thenReturn(students);
        mockMvc.perform(get("/student/age?age=20&range=25"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(filteredStudents.size()));
    }

//    @Test
//    public void wouldFindStudentByFaculty() throws Exception {
//        JSONObject facultyJo = new JSONObject();
//        facultyJo.put("color", "green");
//        facultyJo.put("name", "Slytherin");
//        when(facultyRepository.findById(student.getId())).thenReturn(Optional.of(faculty));
//        when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
//
//        when(studentService.findStudentFaculty(student.getId())).thenReturn(faculty);
//
//        // Act
//        mockMvc.perform(get("/facultyId/faculty", 1L)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(facultyJo)))
//                .andExpect(status().isOk());
//    }

    @Test
    public void getAvatarFromDB() throws Exception {
        long studentId = 1L;
        byte[] avatarBytes = new byte[]{1, 2, 3, 4, 5};
        String mediaType = "image/png";
        Pair<byte[], String> avatarData = Pair.of(avatarBytes, mediaType);

        when(avatarService.getAvatarFromDB(studentId)).thenReturn(avatarData);

        mockMvc.perform(get("/student/{id}/get-avatar-from-db", studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf(mediaType)))
                .andExpect(content().bytes(avatarBytes));
    }

    @Test
    public void getAvatarFromFS() throws Exception {
        long studentId = 1L;
        byte[] avatarBytes = new byte[]{1, 2, 3, 4, 5};
        String mediaType = "image/png";
        Pair<byte[], String> avatarData = Pair.of(avatarBytes, mediaType);

        when(avatarService.getAvatarFromFS(studentId)).thenReturn(avatarData);

        mockMvc.perform(get("/student/{id}/get-avatar-from-fs", studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf(mediaType)))
                .andExpect(content().bytes(avatarBytes));
    }
}
