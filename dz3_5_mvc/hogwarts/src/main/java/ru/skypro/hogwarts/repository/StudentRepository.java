package ru.skypro.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.skypro.hogwarts.model.Student;


import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.name = :name")
    Optional<Student> findStudentByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("update Student s set s.age = :age where s.id = :id")
    void updateAgeStudentById(@Param("id") long id, @Param("age") int age);

    List<Student> findAllByAgeBetween(int maxAge, int minAge);

    List<Student> findByAge(int age);

    List<Student> findStudentsByFaculty_Id(long facultyId);
}
