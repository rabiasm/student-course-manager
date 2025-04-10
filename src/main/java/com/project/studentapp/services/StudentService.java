package com.project.studentapp.services;

import com.project.studentapp.entities.Student;
import com.project.studentapp.repos.StudentRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student updateStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
          Student student = existingStudent.get();
          student.setName(updateStudent.getName());
          student.setEmail(updateStudent.getEmail());
          student.setRegistrationDate(updateStudent.getRegistrationDate());
          return studentRepository.save(student);
        }
        return null;
    }


    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }


    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(Integer id) {
         studentRepository.deleteById(id);
    }

}
