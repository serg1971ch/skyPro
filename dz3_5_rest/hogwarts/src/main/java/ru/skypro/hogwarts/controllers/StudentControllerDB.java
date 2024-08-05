package ru.skypro.hogwarts.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.hogwarts.model.Faculty;
import ru.skypro.hogwarts.model.Student;
import ru.skypro.hogwarts.service.AvatarService;
import ru.skypro.hogwarts.service.StudentServiceBD;


import java.util.List;

@RestController
@RequestMapping("/student")
@Tag(name = "студенты", description = "Эндпойнты для работы со студентами")
public class StudentControllerDB {

    private final StudentServiceBD serviceBD;
    private final AvatarService avatarService;

    public StudentControllerDB(StudentServiceBD serviceBD, AvatarService avatarService) {
        this.serviceBD = serviceBD;
        this.avatarService = avatarService;
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

    @GetMapping(value = "/age", params = "age")
    public List<Student> filterByAge(@RequestParam int age) {
        return serviceBD.filterByAge(age);
    }

    @GetMapping("/age-range")
    public List<Student> filterByRangeAge(@RequestParam int minAge, @RequestParam int maxAge) {
        return serviceBD.filterByRangeAge(minAge, maxAge);
    }

    @GetMapping("/{id}/faculty")
    public Faculty findStudentByFaculty(@PathVariable long id) {
        return serviceBD.findStudentFaculty(id);
    }

    @GetMapping("{id}/get-avatar-from-db")
    public ResponseEntity<byte[]> getAvatarFromDB(@PathVariable long id) {
        return builtResponseEntity(avatarService.getAvatarFromDB(id));
    }

    @GetMapping("{id}/get-avatar-from-fs")
    public ResponseEntity<byte[]> getAvatarFromFS(@PathVariable long id) {
        return builtResponseEntity(avatarService.getAvatarFromFS(id));
    }
    
    public ResponseEntity<byte[]> builtResponseEntity(Pair<byte[], String> pair) {
        byte[] data = pair.getFirst();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(data.length)
                .contentType(MediaType.parseMediaType(pair.getSecond()))
                .body(data);
    }
}
