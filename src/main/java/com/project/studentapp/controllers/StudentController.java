package com.project.studentapp.controllers;


import com.project.studentapp.entities.Student;
import com.project.studentapp.repos.StudentRepository;
import com.project.studentapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService StudentService;

    @Autowired
    public StudentController(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return StudentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return StudentService.findById(id).orElse(null);
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student) {
        return StudentService.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student updateStudent) {
        Optional<Student> existingStudent = StudentService.findById(id);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setName(updateStudent.getName());
            student.setEmail(updateStudent.getEmail());
            student.setRegistrationDate(updateStudent.getRegistrationDate());
            return StudentService.save(student);
        } else {
            return null;
        }
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        StudentService.deleteById(id);
    }


}
