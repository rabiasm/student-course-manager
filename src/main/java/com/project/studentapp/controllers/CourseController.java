package com.project.studentapp.controllers;

import com.project.studentapp.entities.Course;
import com.project.studentapp.repos.CourseRepository;
import com.project.studentapp.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {

        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {

        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Integer id) {

        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {

        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Integer id, @RequestBody Course updateCourse) {
        return courseService.updateCourse(id, updateCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) {

        courseService.deleteCourse(id);
    }
}
