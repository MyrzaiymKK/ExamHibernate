package org.example.dao;

import org.example.entity.Course;
import org.example.entity.Student;

import java.util.List;
import java.util.Map;

public interface CourseDao {
    String saveCourse(Course newcourse);
    Course getById(Long coursetId);
    List<Course> getAllCourses();
    void updateCourse(Long courseId,Course newcourse);
    String deleteCourse(Long courseId);

    Map<Course, List<Student>> getCourseStudents(Long courseId);
    String assignStudentToCourse(Long studentId,Long courseId);
}
