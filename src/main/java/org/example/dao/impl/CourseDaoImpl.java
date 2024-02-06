package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.Hibernateconfig;
import org.example.dao.CourseDao;
import org.example.entity.Course;
import org.example.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDaoImpl implements CourseDao {
      EntityManagerFactory entityManagerFactory = Hibernateconfig.getEntity();
    @Override
    public String saveCourse(Course newcourse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(newcourse);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "Successfully saved";
    }


    @Override
    public Course getById(Long coursetId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course course = null;
        try {
            entityManager.getTransaction().begin();
           course = entityManager.createQuery("select c from Course c where c.id =: add",Course.class)
                    .setParameter("add",coursetId)
                    .getSingleResult();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return course;
    }

    @Override
    public List<Course> getAllCourses() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Course> courses = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            courses =  entityManager.createQuery("select c from Course c",Course.class)
                    .getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return courses;
    }

    @Override
    public void updateCourse(Long courseId, Course newcourse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class,courseId);

            if(course!= null){
                course.setName(newcourse.getName());
                course.setDescription(newcourse.getDescription());

                entityManager.getTransaction().commit();
            }else {
                System.out.println("Course with this id not found");
            }
        }finally {
            entityManager.close();
        }
    }

    @Override
    public String deleteCourse(Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class,courseId);
            entityManager.remove(course);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "Successfully deleted";
    }

    @Override
    public Map<Course, List<Student>> getCourseStudents(Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Map<Course, List<Student>>  map = new HashMap<>();
        try {
            entityManager.getTransaction().begin();
         Course  findCourse =  entityManager.createQuery("select c from Course c where c.id =:addId",Course.class)
                    .setParameter("addId",courseId)
                    .getSingleResult();
         map.put(findCourse,findCourse.getStudent());
         entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return map;
    }


    @Override
    public String assignStudentToCourse(Long studentId, Long courseId) {
//
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class,studentId);
            Course course = entityManager.find(Course.class,courseId);
            course.getStudent().add(student);
            student.getCourse().add(course);

            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e ) {
            System.out.println(e.getMessage());
        }
        return "Successfully assigned";
    }
}
