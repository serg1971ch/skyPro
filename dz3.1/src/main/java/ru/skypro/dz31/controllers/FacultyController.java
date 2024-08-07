package ru.skypro.dz31.controllers;

import org.springframework.web.bind.annotation.*;
import ru.skypro.dz31.model.Faculty;
import ru.skypro.dz31.service.FacultyService;

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
    public Faculty remove(@PathVariable long id) {
        return facultyService.delete(id);
    }

    @GetMapping
    public List<Faculty> filterByColor(@RequestParam String color){
        return facultyService.sortMap(color);
    }
}
