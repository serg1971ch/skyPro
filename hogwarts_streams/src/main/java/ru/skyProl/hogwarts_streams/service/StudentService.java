package ru.skyProl.hogwarts_streams.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skyProl.hogwarts_streams.exceptions.NotFoundException;
import ru.skyProl.hogwarts_streams.model.Faculty;
import ru.skyProl.hogwarts_streams.model.Student;
import ru.skyProl.hogwarts_streams.repository.FacultyRepository;
import ru.skyProl.hogwarts_streams.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public Student create(Student student) {
        logger.info("Was invoked method for creating student");
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
        logger.info("Was invoked method for updating student with id = " + id);
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

    public List<Student> findAll() {
        logger.info("Was invoked method for finding all students");
        return studentRepository.findAll();
    }

    public Student get(long id) {
        logger.info("Was invoked method for getting student with id = {}", id);
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Optional<Student> findByName(String name) {
        logger.info("Was invoked method for find student by name = {}", name);
        return studentRepository.findStudentByName(name);
    }

    public void setStudentAge(long id, int age) {
        studentRepository.updateAgeStudentById(id, age);
    }

    public void remove(long id) {
        logger.info("Was invoked method for removing student with id = {}", id);
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        studentRepository.delete(student);
    }

    public List<Student> filterByAge(int age) {
        logger.info("Was invoked method filter students by age = {}", age);
        return studentRepository.findByAge(age);
    }

    public List<Student> filterByRangeAge(int minAge, int maxAge) {
        logger.info("Was invoked method filter range age of students by min age = {} and max age = {}", minAge, maxAge);
        return studentRepository.findAllByAgeBetween(maxAge, minAge);
    }

    public Faculty  findStudentFaculty(long id) {
        logger.info("Was invoked method find students with faculty id = {}", id);
        return get(id).getFaculty();
    }

    public long countAllStudents() {
        logger.info("Was invoked method count all students");
        return studentRepository.count();
    }

    public double getAverageAge() {
        List<Student> students = studentRepository.findAll();
        logger.info("Was invoked method get average age of students");
        return students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
    }

    public List<Student> getStudentsByLastFiveId() {
        logger.info("Was invoked method for finding latest five students");
        return studentRepository.getLastFiveStudents();
    }

    public void printParallel() {
        logger.info("Was invoked method print parallel");
        List<Student> students = studentRepository.findAll();
        printName(students.get(0));
        printName(students.get(1));

        new Thread(()-> {
            printName(students.get(2));
            printName(students.get(3));
        }).start();

        new Thread(()-> {
            printName(students.get(4));
            printName(students.get(5));
        }).start();
    }

    public void printParallelSynchronized() {
        logger.info("Was invoked method print parallel");
        List<Student> students = studentRepository.findAll();
        printSynchronizedName(students.get(0));
        printSynchronizedName(students.get(1));

        new Thread(()-> {
            printSynchronizedName(students.get(2));
            printSynchronizedName(students.get(3));
        }).start();

        new Thread(()-> {
            printSynchronizedName(students.get(4));
            printSynchronizedName(students.get(5));
        }).start();
    }

    private synchronized void  printSynchronizedName(Student student) {
        logger.info(student.getName());
    }

    private void printName(Student student) {
        logger.info(student.getName());
    }

}
