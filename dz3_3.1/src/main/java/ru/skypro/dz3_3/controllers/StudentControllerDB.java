package ru.skypro.dz3_3.controllers;

import org.springframework.web.bind.annotation.*;
import ru.skypro.dz3_3.model.Student;
import ru.skypro.dz3_3.service.StudentServiceBD;

@RestController
@RequestMapping("/student")
public class StudentControllerDB {
    private final StudentServiceBD serviceBD;

    public StudentControllerDB(StudentServiceBD serviceBD) {
        this.serviceBD = serviceBD;
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return serviceBD.addStudent(student);
    }

    @PutMapping("/{id}/{age}")
    public void update(@PathVariable long id, @RequestBody int age) {
        serviceBD.setStudentAge(id, age);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable long id) {
        return (Student) serviceBD.findAll(id);
    }

    @DeleteMapping
    public void remove(@RequestBody Student student) {
        serviceBD.remove(student);
    }
}
