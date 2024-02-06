package org.example.dao;

import org.example.entity.Course;
import org.example.entity.Student;

import java.util.List;

public interface CourseDao {
    String saveCourse(Course newcourse);
    Course getById(Long coursetId);
    List<Course> getAllCourses();
    void updateCourse(Long courseId,Course newcourse);
    String deleteCourse(Long courseId);

    List<Course> getCourseStudents(Long courseId);
    String assignStudentToCourse(Long studentId,Long courseId);
}
