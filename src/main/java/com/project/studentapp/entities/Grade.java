package com.project.studentapp.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @OneToOne
    @JoinColumn(name = "enrollment_id", nullable = false )
    private Enrollment enrollment;

    @Column(name = "letter_grade")
    private String letterGrade;

    @Column(name = "score")
    private Double score;
}
