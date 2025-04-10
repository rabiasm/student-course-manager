package com.project.studentapp.repos;

import com.project.studentapp.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository  extends JpaRepository<Enrollment, Integer> {

   List<Enrollment> findByStudentId(Integer studentId);

   List<Enrollment> findByCourseId(Integer courseId);

   boolean existsByStudentIdAndCourseId(Integer studentId, Integer courseId);
}
