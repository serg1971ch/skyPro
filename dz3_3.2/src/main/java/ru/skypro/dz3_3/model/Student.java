package ru.skypro.dz3_3.model;

//import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "id", description = "id студента")
    private Long id;
    @Schema(name = "name", description = "Имя студента")
    private String name;
    @Schema(name = "age", description = "Возраст студента")
    private int age;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    //    public Student(Long id, String name, int age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }
//
//    public Student() {
//
//    }
}
