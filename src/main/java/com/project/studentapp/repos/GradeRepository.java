package com.project.studentapp.repos;

import com.project.studentapp.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository <Grade, Integer> {
    Grade findByEnrollmentId(Integer enrollmentId);

    Grade findByEnrollment_Student_IdAndEnrollment_Course_Id(int studentId, int courseId);

    List<Grade> findByEnrollment_Student_Id(int studentId);

    List<Grade> findByEnrollment_Course_Id(int courseId);
}
