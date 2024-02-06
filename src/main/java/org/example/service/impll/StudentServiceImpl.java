package org.example.service.impll;

import org.example.dao.StudentDao;
import org.example.dao.impl.StudentDaoImpl;
import org.example.entity.Student;
import org.example.service.StudentService;

import java.time.LocalDate;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();
    @Override
    public String saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public Student getById(Long studentId) {
        return studentDao.getById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public void updateStudent(Long studId, Student newStudent) {
        studentDao.updateStudent(studId,newStudent);
    }

    @Override
    public String deleteStud(Long studId) {
        return studentDao.deleteStud(studId);
    }

    @Override
    public List<Student> getStudentCourses(Long studentId) {
        return studentDao.getStudentCourses(studentId);
    }

    @Override
    public List<Student> getStudentBuEntollment(LocalDate studentId) {
        return studentDao.getStudentBuEntollment(studentId);
    }
}
