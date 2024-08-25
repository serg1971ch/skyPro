package ru.skyProl.hogwarts_streams.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skyProl.hogwarts_streams.model.Faculty;
import ru.skyProl.hogwarts_streams.model.Student;
import ru.skyProl.hogwarts_streams.service.AvatarService;
import ru.skyProl.hogwarts_streams.service.FacultyService;
import ru.skyProl.hogwarts_streams.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/student")
@Tag(name = "студенты", description = "Эндпойнты для работы со студентами")
public class StudentController {

    private final StudentService serviceBD;
    private final AvatarService avatarService;
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentService serviceBD, AvatarService avatarService) {
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

    @GetMapping("/count")
    public long getCountAllStudents() {
        return serviceBD.countAllStudents();
    }

    @GetMapping("/average")
    public double getAverageAgeStudents() {
        return  serviceBD.getAverageAge();
    }

    @GetMapping("/last-5")
    public int getLast5Students() {
        List<Student> responseList = serviceBD.getStudentsByLastFiveId();
        return responseList.size();
    }

    @GetMapping("/letter")
    public List<Student> getLetterStudentsWithA() {
        return serviceBD.findAll().stream()
                .filter(l->l.getName().toUpperCase().startsWith("A"))
                .sorted() // Сортировка в алфавитном порядке
                .collect(Collectors.toList());
    }

    @GetMapping("/calculate/sum")
    public void calculateSum() {
        long start1 = System.currentTimeMillis();
        int sumOption1 = Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b);

        long finish1 = System.currentTimeMillis();
        logger.info("Operation time of option 1: " + (finish1 - start1) +  " ms");

        long start2 = System.currentTimeMillis();
        int sumOption2 = Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .parallel()
                .reduce(0, (a, b) -> a + b);

        logger.info("Operation time of option 2: " + (System.currentTimeMillis() - start2) +  " ms");
    }
}
