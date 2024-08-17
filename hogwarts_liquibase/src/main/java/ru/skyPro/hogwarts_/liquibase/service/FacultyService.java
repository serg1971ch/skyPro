package ru.skyPro.hogwarts_.liquibase.service;

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

    public FacultyService(FacultyRepository facultyRepository, StudentRepository studentRepository) {
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }

    public Faculty create(Faculty faculty) {
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }

    public Faculty update(long id, Faculty faculty) {
        Faculty oldFaculty = facultyRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        oldFaculty.setName(faculty.getName());
        oldFaculty.setColor(faculty.getColor());
        return facultyRepository.save(oldFaculty);
    }

    public List<Faculty> findAll(long id) {
        return facultyRepository.findAll();
    }

    public Faculty get(long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void remove(long id) {
        Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        facultyRepository.delete(faculty);
    }

    public List<Faculty> filterByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }

    public List<Faculty> filterByColorOrName(String colorOrName) {
        return facultyRepository.findAllByColorIgnoreCaseOrNameIgnoreCase(colorOrName, colorOrName);
    }

    public List<Student> findStudentsByFacultyId(long id) {
        return studentRepository.findStudentsByFaculty_Id(id);
    }
}
