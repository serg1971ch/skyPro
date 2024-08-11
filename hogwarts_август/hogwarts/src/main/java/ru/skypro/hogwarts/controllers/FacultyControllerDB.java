package ru.skypro.hogwarts.controllers;

import org.springframework.web.bind.annotation.*;
import ru.skypro.hogwarts.model.Faculty;
import ru.skypro.hogwarts.model.Student;
import ru.skypro.hogwarts.service.FacultyServiceBD;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculty")
public class FacultyControllerDB {
    private final FacultyServiceBD facultyServiceBD;

    public FacultyControllerDB(FacultyServiceBD facultyServiceBD) {
        this.facultyServiceBD = facultyServiceBD;
    }

    @PostMapping
    public Faculty create(@RequestBody Faculty faculty) {
        return facultyServiceBD.create(faculty);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Faculty faculty) {
        facultyServiceBD.update(id, faculty);
    }

    @GetMapping("/{id}")
    public Faculty get(@PathVariable long id) {
        return facultyServiceBD.get(id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        facultyServiceBD.remove(id);
    }

    @GetMapping(params = "color")
    public List<Faculty> filterByColor(@RequestParam String color) {
        return facultyServiceBD.filterByColor(color);
    }

    @GetMapping(params = "colorOrName")
    private List<Faculty> filterByColorOrName(@PathVariable String colorOrName) {
        return facultyServiceBD.filterByColorOrName(colorOrName);
    }

    @GetMapping("/{id}/students")
    private List<Student> findStudentsByFacultyId(@PathVariable long id) {
        return facultyServiceBD.findStudentsByFacultyId(id);
    }
}
