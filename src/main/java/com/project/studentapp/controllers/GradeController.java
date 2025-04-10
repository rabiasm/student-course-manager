package com.project.studentapp.controllers;

import com.project.studentapp.entities.Grade;
import com.project.studentapp.services.EnrollmentService;
import com.project.studentapp.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/{gradeId}")
    public Grade getGradeById(@PathVariable int gradeId) {
        return gradeService.getGradeById(gradeId);
    }

    @PostMapping("/{enrollmentId}")
    public Grade createGrade(@PathVariable int enrollmentId, @RequestBody Grade grade) {
       return gradeService.createGrade(enrollmentId, grade);
    }

    @PutMapping("/{gradeId}")
    public Grade updateGrade(@PathVariable int gradeId, @RequestBody Grade grade) {
        return gradeService.updateGradeById(gradeId, grade);
    }

    @DeleteMapping("/{gradeId}")
    public String deleteGrade(@PathVariable int gradeId) {
        return gradeService.deleteGrade(gradeId);
    }

    @GetMapping("/student/{studentId}")
    public List<Grade> getGradesByStudentId(@PathVariable int studentId) {
        return gradeService.getGradesByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Grade> getGradesByCourseId(@PathVariable int courseId) {
        return gradeService.getGradesByCourseId(courseId);
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    public Grade getGradeByStudentAndCourse(@PathVariable int studentId, @PathVariable int courseId) {
        return gradeService.getGradeByStudentAndCourse(studentId, courseId);
    }
}
