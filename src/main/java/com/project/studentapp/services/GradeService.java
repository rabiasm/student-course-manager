package com.project.studentapp.services;


import com.project.studentapp.entities.Enrollment;
import com.project.studentapp.entities.Grade;
import com.project.studentapp.repos.EnrollmentRepository;
import com.project.studentapp.repos.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository, EnrollmentRepository enrollmentRepository) {
        this.gradeRepository = gradeRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public Grade createGrade(Integer enrollmentId, Grade grade) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElse(null);
        if (enrollment == null) {
            return null;
        }
        grade.setEnrollment(enrollment);
        return gradeRepository.save(grade);
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade getGradeById(Integer id) {
        return gradeRepository.findById(id).orElse(null);
    }

    public Grade updateGradeById(Integer id, Grade updateGrade) {
        Grade existingGrade = gradeRepository.findById(id).orElse(null);
        if (existingGrade == null) {
            return null;
        }
        existingGrade.setLetterGrade(updateGrade.getLetterGrade());
        existingGrade.setScore(updateGrade.getScore());
        return gradeRepository.save(existingGrade);
    }

    public String deleteGrade(Integer id) {
        if (!gradeRepository.existsById(id)) {
            return "Grade not found";
        }
        gradeRepository.deleteById(id);
        return "Grade deleted";
    }

    public Grade getGradeByStudentAndCourse(int studentId, int courseId) {
        return gradeRepository.findByEnrollment_Student_IdAndEnrollment_Course_Id(studentId, courseId);
    }

    public List<Grade> getGradesByStudentId(int studentId) {
        return gradeRepository.findByEnrollment_Student_Id(studentId);
    }

    public List<Grade> getGradesByCourseId(int courseId) {
        return gradeRepository.findByEnrollment_Course_Id(courseId);
    }
}
