package ru.skypro.hogwarts.model;

//import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
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

    public Student( String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public Student(long l, String alex, int i) {
//    }

}
