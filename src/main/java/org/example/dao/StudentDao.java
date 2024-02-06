package org.example.dao;

import org.example.entity.Course;
import org.example.entity.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface StudentDao  {
    String saveStudent(Student student);
    Student getById(Long studentId);
    List<Student> getAllStudents();
    void updateStudent(Long studId,Student newStudent);
    String deleteStud(Long studId);

    Map<Student, List<Course>> getStudentCourses(Long studentId);
    List<Student> getStudentBuEntollment(LocalDate studentId);

}
