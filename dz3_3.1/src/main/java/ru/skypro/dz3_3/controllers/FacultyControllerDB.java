package ru.skypro.dz3_3.controllers;

import org.springframework.web.bind.annotation.*;
import ru.skypro.dz3_3.model.Faculty;
import ru.skypro.dz3_3.service.FacultyServiceBD;

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
        return facultyServiceBD.addFaculty(faculty);
    }

//    @PutMapping
//    public void update(@RequestBody Faculty faculty) {
//        facultyServiceBD.updateFaculty(faculty);
//    }

    @GetMapping("/{id}")
    public Optional<Faculty> get(@PathVariable long id) {
        return facultyServiceBD.findById(id);
    }

    @DeleteMapping
    public void remove(@RequestBody Faculty faculty) {
        facultyServiceBD.remove(faculty);
    }
}
