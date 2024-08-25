package ru.skyProl.hogwarts_streams.controllers;

import org.springframework.web.bind.annotation.*;
import ru.skyProl.hogwarts_streams.model.Faculty;
import ru.skyProl.hogwarts_streams.model.Student;
import ru.skyProl.hogwarts_streams.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty create(@RequestBody Faculty faculty) {
        return facultyService.create(faculty);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Faculty faculty) {
        facultyService.update(id, faculty);
    }

    @GetMapping("/{id}")
    public Faculty get(@PathVariable long id) {
        return facultyService.get(id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        facultyService.remove(id);
    }

    @GetMapping(params = "color")
    public List<Faculty> filterByColor(@RequestParam String color) {
        return facultyService.filterByColor(color);
    }

    @GetMapping(params = "colorOrName")
    private List<Faculty> filterByColorOrName(@PathVariable String colorOrName) {
        return facultyService.filterByColorOrName(colorOrName);
    }

    @GetMapping("/{id}/students")
    private List<Student> findStudentsByFacultyId(@PathVariable long id) {
        return facultyService.findStudentsByFacultyId(id);
    }
}
