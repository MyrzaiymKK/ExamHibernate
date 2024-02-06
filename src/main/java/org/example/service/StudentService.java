package org.example.service;

import org.example.entity.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    String saveStudent(Student student);
    Student getById(Long studentId);
    List<Student> getAllStudents();
    void updateStudent(Long studId,Student newStudent);
    String deleteStud(Long studId);

    List<Student> getStudentCourses(Long studentId);
    List<Student> getStudentBuEntollment(LocalDate studentId);
}
