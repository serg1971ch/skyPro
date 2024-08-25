package ru.skyProl.hogwarts_streams.model;

//import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student implements Comparable<Student> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "id", description = "id студента")
//    @JsonProperty("id")
    private Long id;
    @Schema(name = "name", description = "Имя студента")
//    @JsonProperty("name")
    private String name;
    @Schema(name = "age", description = "Возраст студента")
//    @JsonProperty("age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
//    @JsonProperty("faculty")
    private Faculty faculty;

    public Student(String name, int age, Faculty faculty) {
        this.name = name;
        this.age = age;
        this.faculty = faculty;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name); // Сравнение по имени
    }
}
