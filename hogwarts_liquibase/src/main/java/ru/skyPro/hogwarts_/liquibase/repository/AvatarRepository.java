package ru.skyPro.hogwarts_.liquibase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skyPro.hogwarts_.liquibase.model.Avatar;

import java.util.Optional;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudent_Id(Long id);
}
