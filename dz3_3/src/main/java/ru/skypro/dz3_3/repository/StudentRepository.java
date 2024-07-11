package ru.skypro.dz3_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.skypro.dz3_3.model.Student;


import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.name = :name")
    Optional<Student> findStudentByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("update Student s set s.age = :age where s.id = :id")
    void updateAgeStudentById(@Param("id") long id, @Param("age") int age);
}
