package org.example.service.impll;

import org.example.dao.CourseDao;
import org.example.dao.impl.CourseDaoImpl;
import org.example.entity.Course;
import org.example.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();
    @Override
    public String saveCourse(Course newcourse) {
        return courseDao.saveCourse(newcourse);
    }

    @Override
    public Course getById(Long coursetId) {
        return courseDao.getById(coursetId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public void updateCourse(Long courseId, Course newcourse) {
      courseDao.updateCourse(courseId,newcourse);
    }

    @Override
    public String deleteCourse(Long courseId) {
        return courseDao.deleteCourse(courseId);
    }

    @Override
    public List<Course> getCourseStudents(Long courseId) {
        return courseDao.getCourseStudents(courseId);
    }

    @Override
    public String assignStudentToCourse(Long studentId, Long courseId) {
        return courseDao.assignStudentToCourse(studentId,courseId);
    }
}
