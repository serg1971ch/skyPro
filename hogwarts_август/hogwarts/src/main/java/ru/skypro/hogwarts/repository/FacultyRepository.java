package ru.skypro.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.hogwarts.model.Faculty;


import java.util.*;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findAllByColor(String color);

    List<Faculty> findAllByColorIgnoreCaseOrNameIgnoreCase(String color, String name);

}
