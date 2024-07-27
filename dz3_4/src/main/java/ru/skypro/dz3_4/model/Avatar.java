package ru.skypro.dz3_4.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "avatars")
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pathFile;
    private long size;
    private String mediaType;
    @Column(columnDefinition = "oid")
    private byte[] bytes;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;


}
