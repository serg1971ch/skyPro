package ru.skypro.hogwarts.model;

//import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
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

    public Student( String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public Student(long l, String alex, int i) {
//    }

}
