package ru.skypro.hogwarts.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pathFile;
    private long size;
    private String mediaType;
//    @Column(columnDefinition = "oid")
    @Lob
    private byte[] bytes;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
