package org.example.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "studentss")
@Getter @Setter
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",
        sequenceName = "students_seq",
        allocationSize = 1)
public class Student extends BaseEntity {
    private String name;
    @Column(unique = true)
    private String email;
    @Column()
    private LocalDate enrollement_date;
    @ManyToMany
    private List<Course> course;

    public Student(String name, String email, LocalDate enrollement_date) {
        this.name = name;
        this.email = email;
        this.enrollement_date = enrollement_date;
    }
}