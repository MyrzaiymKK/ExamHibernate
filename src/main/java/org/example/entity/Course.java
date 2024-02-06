package org.example.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "coursess")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",
        sequenceName = "courses_seq",
        allocationSize = 1)
public class Course extends BaseEntity {
    @Column(unique = true)
    private String name;
    private String description;


    @ManyToMany(mappedBy = "course")
    private List<Student> student;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return " Courses:  " +
                "name='" + name + '\'' +
                ", description='" + description ;
    }
}
