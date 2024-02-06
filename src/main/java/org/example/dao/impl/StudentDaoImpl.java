package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.Hibernateconfig;
import org.example.dao.StudentDao;
import org.example.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    EntityManagerFactory entityManagerFactory = Hibernateconfig.getEntity();
    @Override
    public String saveStudent(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "Successfully saved";
    }

    @Override
    public Student getById(Long studentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = null;
        try {
            entityManager.getTransaction().begin();
           student = entityManager.createQuery("select s from Student s where s.id =:addId",Student.class)
                    .setParameter("addId",studentId)
                    .getSingleResult();
           entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Student> students = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
           students =  entityManager.createQuery("select s from Student s",Student.class)
                    .getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return students;
    }

    @Override
    public void updateStudent(Long studId, Student newStudent) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class,studId);

            if(student != null){
                student.setName(newStudent.getName());
                student.setEmail(newStudent.getEmail());
                student.setEnrollement_date(newStudent.getEnrollement_date());
                entityManager.merge(student);
                entityManager.getTransaction().commit();
            }else {
                System.out.println("Student with this id not found");
            }
        }finally {
            entityManager.close();
        }
    }

    @Override
    public String deleteStud(Long studId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class,studId);
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "Successfully deleted";
    }

    @Override
    public List<Student> getStudentCourses(Long studentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("select s from Student s inner join Course c on s.id = c.student.size",Student.class)
                    .getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Student> getStudentBuEntollment(LocalDate studentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Student > students = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
          students =   entityManager.createQuery("select s from Student s where s.enrollement_date =:add",Student.class)
                    .setParameter("add",studentId)
                    .getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return students;
    }
}
