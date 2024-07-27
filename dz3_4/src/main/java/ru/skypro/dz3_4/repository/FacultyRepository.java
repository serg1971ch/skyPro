package ru.skypro.dz3_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.dz3_4.model.Faculty;

import java.util.*;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findAllByColor(String color);

    List<Faculty> findAllByColorIgnoreCaseOrNameIgnoreCase(String color, String name);

}
