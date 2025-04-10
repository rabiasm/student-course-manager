package com.project.studentapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "course_code", unique = true, nullable = false)
    private String  courseCode;

    @Column(name = "course_credit", nullable = false)
    private int courseCredit;
}
