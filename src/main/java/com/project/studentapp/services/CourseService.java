package com.project.studentapp.services;

import com.project.studentapp.entities.Course;
import com.project.studentapp.repos.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Integer id, Course updateCourse) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setName(updateCourse.getName());
            course.setCourseCode(updateCourse.getCourseCode());
            course.setCourseCredit(updateCourse.getCourseCredit());
            return courseRepository.save(course);
        }
        return null;
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
