package ru.skypro.dz3_3.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.skypro.dz3_3.model.Faculty;
import ru.skypro.dz3_3.model.Student;
import ru.skypro.dz3_3.service.StudentServiceBD;

import java.util.List;

@RestController
@RequestMapping("/student")
@Tag(name = "студенты", description = "Эндпойнты для работы со студентами")
public class StudentControllerDB {

    private final StudentServiceBD serviceBD;

    public StudentControllerDB(StudentServiceBD serviceBD) {
        this.serviceBD = serviceBD;
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return serviceBD.create(student);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Student student) {
        serviceBD.update(id, student);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable long id) {
        return serviceBD.get(id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        serviceBD.remove(id);
    }

    @GetMapping(params = "age")
    public List<Student> filterByAge(@RequestParam int age) {
        return serviceBD.filterByAge(age);
    }

    @GetMapping(params = {"minAge", "maxAge"})
    public List<Student> filterByRangeAge(@RequestParam int ageMin, @RequestParam int ageMax) {
        return serviceBD.filterByRangeAge(ageMin, ageMax);
    }

    @GetMapping("/{id}/faculty")
    public Faculty findStudentByFaculty(@PathVariable long id) {
        return serviceBD.findStudentsFaculty(id);
    }
}
