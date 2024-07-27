package ru.skypro.dz3_3.service;

import org.springframework.stereotype.Service;
import ru.skypro.dz3_3.model.Student;
import ru.skypro.dz3_3.repository.StudentRepository;


import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceBD {
    private final StudentRepository studentRepository;

    public StudentServiceBD(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAll(long id) {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> findByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    public void setStudentAge(long id, int age) {
        studentRepository.updateAgeStudentById(id, age);
    }

    public void remove(Student student) {
        studentRepository.delete(student);
    }
}
