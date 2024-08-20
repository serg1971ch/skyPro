package ru.skyPro.hogwarts_.liquibase.service;

import org.springframework.stereotype.Service;
import ru.skyPro.hogwarts_.liquibase.exceptions.NotFoundException;
import ru.skyPro.hogwarts_.liquibase.model.Faculty;
import ru.skyPro.hogwarts_.liquibase.model.Student;
import ru.skyPro.hogwarts_.liquibase.repository.FacultyRepository;
import ru.skyPro.hogwarts_.liquibase.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public Student create(Student student) {
        Faculty faculty = null;
        if(student.getFaculty() != null && student.getFaculty().getId() != null) {
            faculty = facultyRepository.findById(student.getFaculty().getId())
                    .orElseThrow(() -> new NotFoundException(student.getFaculty().getId()));
        }
        student.setFaculty(faculty);
        student.setId(null);
        return studentRepository.save(student);
    }

    public Student update(long id, Student student) {
        Student oldStudent = studentRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        Faculty faculty = null;
        if(student.getFaculty() != null && student.getFaculty().getId() != null) {
            faculty = facultyRepository.findById(student.getFaculty().getId())
                    .orElseThrow(() -> new NotFoundException(student.getFaculty().getId()));
        }
        oldStudent.setAge(student.getAge());
        oldStudent.setName(student.getName());
        oldStudent.setFaculty(faculty);
        return studentRepository.save(oldStudent);
    }

    public List<Student> findAll(long id) {
        return studentRepository.findAll();
    }

    public Student get(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Optional<Student> findByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    public void setStudentAge(long id, int age) {
        studentRepository.updateAgeStudentById(id, age);
    }

    public void remove(long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        studentRepository.delete(student);
    }

    public List<Student> filterByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public List<Student> filterByRangeAge(int minAge, int maxAge) {
        return studentRepository.findAllByAgeBetween(maxAge, minAge);
    }

    public Faculty  findStudentFaculty(long id) {
        return get(id).getFaculty();
    }

    public long countAllStudents() {
        return studentRepository.count();
    }

    public int getAverageAge() {
        return studentRepository.averageAgeStudents();
    }

    public List<Student> getStudentsByLastFiveId() {
        return studentRepository.getLastFiveStudents();
    }

}