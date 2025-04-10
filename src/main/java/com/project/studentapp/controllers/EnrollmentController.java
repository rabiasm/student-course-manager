package com.project.studentapp.controllers;


import com.project.studentapp.entities.Course;
import com.project.studentapp.entities.Enrollment;
import com.project.studentapp.entities.Student;
import com.project.studentapp.repos.EnrollmentRepository;
import com.project.studentapp.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Integer id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @GetMapping("/students/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Integer studentId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        return enrollments.stream().map(Enrollment::getCourse).toList();
    }

    @GetMapping("/courses/{courseId}/students")
    public List<Student> getStudentsByCourseId(@PathVariable Integer courseId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByCourseId(courseId);
        return enrollments.stream().map(Enrollment::getStudent).toList();
    }

    @GetMapping("/student/{studentId}")
    public List<Enrollment> getEnrollmentsByStudentId(@PathVariable Integer studentId) {
        return enrollmentService.getEnrollmentsByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Enrollment> getEnrollmentsByCourseId(@PathVariable Integer courseId) {
        return enrollmentService.getEnrollmentsByCourseId(courseId);
    }

    @PostMapping
    public String enrollStudent(@RequestBody Enrollment enrollment) {
        return enrollmentService.enrollStudent(enrollment.getStudent().getId(), enrollment.getCourse().getId());
    }

    @PutMapping("/{id}")
    public Enrollment updateEnrollment(@PathVariable Integer id, @RequestBody Enrollment enrollment) {
        return enrollmentService.updateEnrollment(id, enrollment);
    }

    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Integer id) {
        return enrollmentService.deleteEnrollment(id);
    }


}
