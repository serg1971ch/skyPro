package ru.skypro.dz31.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.skypro.dz31.model.Student;
import ru.skypro.dz31.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
@Tag(name = "Студенты", description = "Эндпоинты для работы со студентами")
public class StudentsController {

    public final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Эндпоинт для создания студента")
    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Student student) {
        studentService.update(id, student);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable long id) {
        return studentService.get(id);
    }

    @DeleteMapping("/{id}")
    public Student remove(@PathVariable long id) {
        return studentService.delete(id);
    }

    @GetMapping
    public List<Student> filterByAge(@RequestParam int age){
        return studentService.sortMap(age);
    }
}
