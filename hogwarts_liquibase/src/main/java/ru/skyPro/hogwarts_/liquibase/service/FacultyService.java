package ru.skyPro.hogwarts_.liquibase.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skyPro.hogwarts_.liquibase.exceptions.NotFoundException;
import ru.skyPro.hogwarts_.liquibase.model.Faculty;
import ru.skyPro.hogwarts_.liquibase.model.Student;
import ru.skyPro.hogwarts_.liquibase.repository.FacultyRepository;
import ru.skyPro.hogwarts_.liquibase.repository.StudentRepository;

import java.util.List;


@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;
    private final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository, StudentRepository studentRepository) {
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }

    public Faculty create(Faculty faculty) {
        logger.info("Was invoked method for create faculty");
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }

    public Faculty update(long id, Faculty faculty) {
        logger.info("Was invoked method for update faculty with id = " + id);
        Faculty oldFaculty = facultyRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        oldFaculty.setName(faculty.getName());
        oldFaculty.setColor(faculty.getColor());
        return facultyRepository.save(oldFaculty);
    }

    public List<Faculty> findAll(long id) {
        logger.info("Was invoked method for find all faculties");
        return facultyRepository.findAll();
    }

    public Faculty get(long id) {
        logger.info("Was invoked method for get faculty with id = {}", id);
        return facultyRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void remove(long id) {
        logger.info("Was invoked method for remove faculty with id = {}", id);
        Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        facultyRepository.delete(faculty);
    }

    public List<Faculty> filterByColor(String color) {
        logger.info("Was invoked method for filter faculties by color = {}", color);
        return facultyRepository.findAllByColor(color);
    }

    public List<Faculty> filterByColorOrName(String colorOrName) {
        logger.info("Was invoked method for filter faculties by color or name = {}", colorOrName);
        return facultyRepository.findAllByColorIgnoreCaseOrNameIgnoreCase(colorOrName, colorOrName);
    }

    public List<Student> findStudentsByFacultyId(long id) {
        logger.info("Was invoked method for find students by faculty id = {}", id);
        return studentRepository.findStudentsByFaculty_Id(id);
    }
}
