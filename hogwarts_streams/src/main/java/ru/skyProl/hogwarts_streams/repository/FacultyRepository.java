package ru.skyProl.hogwarts_streams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skyProl.hogwarts_streams.model.Faculty;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findAllByColor(String color);

    List<Faculty> findAllByColorIgnoreCaseOrNameIgnoreCase(String color, String name);

}
