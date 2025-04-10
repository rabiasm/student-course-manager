package com.project.studentapp.services;

import com.project.studentapp.entities.Course;
import com.project.studentapp.entities.Enrollment;
import com.project.studentapp.entities.Grade;
import com.project.studentapp.entities.Student;
import com.project.studentapp.repos.CourseRepository;
import com.project.studentapp.repos.EnrollmentRepository;
import com.project.studentapp.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public EnrollmentService (EnrollmentRepository enrollmentRepository,
                              StudentRepository studentRepository,
                              CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public String enrollStudent(Integer studentId, Integer courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return "Student not found";

        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) return "Course not found";

        boolean alreadyEnrolled = enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId);
        if (alreadyEnrolled) {
            return "Student already enrolled";
        }

        if (student.getTotalCredits() + course.getCourseCredit() > 30) {
            return  "A student cannot exceed the maximum credit limit!";
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setStatus("Enrolled");

        enrollmentRepository.save(enrollment);


        student.setTotalCredits(student.getTotalCredits() + course.getCourseCredit());
        studentRepository.save(student);

        return "Student successfully enrolled";

    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollmentById(Integer id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    public Enrollment updateEnrollment(Integer id, Enrollment updatedEnrollment) {
        Optional<Enrollment> enrollmentOptional = enrollmentRepository.findById(id);
        if (enrollmentOptional.isPresent()) {
            Enrollment existingEnrollment = enrollmentOptional.get();
            existingEnrollment.setStudent(updatedEnrollment.getStudent());
            existingEnrollment.setStatus(updatedEnrollment.getStatus());
            existingEnrollment.setStatus(updatedEnrollment.getStatus());
            return enrollmentRepository.save(existingEnrollment);
        }
        return null;
    }

    public String deleteEnrollment(Integer id) {
        Optional<Enrollment> enrollmentOptional = enrollmentRepository.findById(id);
        if (enrollmentOptional.isPresent()) {
            Enrollment enrollment = enrollmentOptional.get();

            Student student = enrollment.getStudent();
            Course course = enrollment.getCourse();
            student.setTotalCredits(student.getTotalCredits() - course.getCourseCredit());
            studentRepository.save(student);

            enrollmentRepository.deleteById(id);
            return "Student successfully deleted";
        }
        return "Enrollment not found!";
    }

    public List<Enrollment> getEnrollmentsByStudentId(Integer studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourseId(Integer courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }
}
