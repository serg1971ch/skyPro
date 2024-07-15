package ru.skypro.dz3_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.dz3_3.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}
