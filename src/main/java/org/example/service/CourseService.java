package org.example.service;

import org.example.entity.Course;

import java.util.List;

public interface CourseService {
    String saveCourse(Course newcourse);
    Course getById(Long coursetId);
    List<Course> getAllCourses();
    void updateCourse(Long courseId,Course newcourse);
    String deleteCourse(Long courseId);

    List<Course> getCourseStudents(Long courseId);
    String assignStudentToCourse(Long studentId,Long courseId);
}
