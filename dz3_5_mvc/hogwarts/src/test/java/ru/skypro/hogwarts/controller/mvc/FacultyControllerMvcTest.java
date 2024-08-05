package ru.skypro.hogwarts.controller.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.skypro.hogwarts.controllers.FacultyControllerDB;
import ru.skypro.hogwarts.controllers.StudentControllerDB;
import ru.skypro.hogwarts.model.Faculty;
import ru.skypro.hogwarts.model.Student;
import ru.skypro.hogwarts.repository.FacultyRepository;
import ru.skypro.hogwarts.service.FacultyServiceBD;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FacultyControllerDB.class)
public class FacultyControllerMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyServiceBD facultyService;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FacultyRepository facultyRepository;

    @Test
    void postFacultyWithMockTest() throws Exception {
        long facultyId = new Random().nextLong(1, 1000);
        Faculty faculty = new Faculty("Gryffindor", "Red");
        Faculty savedFaculty = new Faculty(1L, "Gryffindor", "Red");

        Mockito.when(facultyService.create(any(Faculty.class))).thenReturn(savedFaculty);

        mockMvc.perform(post("/faculty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(faculty)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(savedFaculty.getId()))
                .andExpect(jsonPath("$.name").value(savedFaculty.getName()))
                .andExpect(jsonPath("$.color").value(savedFaculty.getColor()));
    }

    @Test
    public void testGetFaculty() throws Exception {
        Faculty faculty = new Faculty(1L, "Gryffindor", "Red");
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        Mockito.when(facultyService.get(anyLong())).thenReturn(faculty);

        mockMvc.perform(get("/faculty/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(faculty.getId()))
                .andExpect(jsonPath("$.name").value(faculty.getName()))
                .andExpect(jsonPath("$.color").value(faculty.getColor()));
    }

    @Test
    public void testUpdateFaculty() throws Exception {
        Faculty updatedInfo = new Faculty("Slytherin", "Green");
        Faculty updatedFaculty = new Faculty( "Slytherin1", "Green");

        Mockito.when(facultyService.update(anyLong(), any(Faculty.class))).thenReturn(updatedFaculty);

        mockMvc.perform(post("/faculty/{id}", 1L)

                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedInfo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(updatedFaculty.getId()))
                .andExpect(jsonPath("$.name").value(updatedFaculty.getName()))
                .andExpect(jsonPath("$.color").value(updatedFaculty.getColor()));
    }

    @Test
    public void testDeleteFaculty() throws Exception {
        Mockito.doNothing().when(facultyService).remove(anyLong());

        mockMvc.perform(delete("/faculty/{id}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindStudentsByFacultyId() throws Exception {
        List<Student> students = Arrays.asList(
                new Student(1L, "Harry Potter", 17, null),
                new Student(2L, "Hermione Granger", 17, null)
        );

        Mockito.when(facultyService.findStudentsByFacultyId(anyLong())).thenReturn(students);

        mockMvc.perform(get("/faculty/{id}/students", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(students.size()))
                .andExpect(jsonPath("$[0].id").value(students.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(students.get(0).getName()))
                .andExpect(jsonPath("$[0].age").value(students.get(0).getAge()))
                .andExpect(jsonPath("$[1].id").value(students.get(1).getId()))
                .andExpect(jsonPath("$[1].name").value(students.get(1).getName()))
                .andExpect(jsonPath("$[1].age").value(students.get(1).getAge()));
    }

    @Test
    @DisplayName("Должен возвращать список факультетов по цвету или по имени факультета")
    public void testFilterByColorOrName() throws Exception {
        List<Faculty> faculties = Arrays.asList(
                new Faculty(1L, "Gryffindor", "Red"),
                new Faculty(2L, "Slytherin", "Green")
        );

        Mockito.when(facultyService.filterByColorOrName(anyString())).thenReturn(faculties);

        mockMvc.perform(get("/faculty")
                        .param("color", "Red")
                        .param("name", "Gryffindor"))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.length()").value(1))
//                .andExpect(jsonPath("$[0].id").value(faculties.get(0).getId()))
//                .andExpect(jsonPath("$[0].name").value(faculties.get(0).getName()));
//                .andExpect(jsonPath("$[0].name").value(faculties.get(0).getColor()));
    }

    @Test
    @DisplayName("Возвращает список всех факультетов по цвету")
    public void filterByColorTest() throws Exception {
        List<Faculty> faculties = Arrays.asList(
                new Faculty("red", "Gryffindor"),
                new Faculty("red", "Slytherin"),
                new Faculty("blue", "Slytherin")
        );

        Mockito.when(facultyService.filterByColor(anyString())).thenReturn(faculties);

        mockMvc.perform(get("/faculty").param("color", "red"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].id").value(faculties.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(faculties.get(0).getName()))
                .andExpect(jsonPath("$[0].color").value(faculties.get(0).getColor()));
    }
}
