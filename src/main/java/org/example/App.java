package org.example;

import org.example.config.Hibernateconfig;
import org.example.entity.Course;
import org.example.entity.Student;
import org.example.service.CourseService;
import org.example.service.StudentService;
import org.example.service.impll.CourseServiceImpl;
import org.example.service.impll.StudentServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        //System.out.println(Hibernateconfig.getEntity());
        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        while (true){
            System.out.println("""
                    Student                 Course
                    
                    1.Save                    8.Save
                    2.get BY iD               9.Get by id
                    3.Get All                 10.Get All
                    4.Update                  11.Update
                    5.Remove                  12.Remove
                    6.Get Student courses     13.Get Course Student
                    7.Get By enrollement      14.Assign 
                    
                    """);
            switch (scanner.nextInt()){
                case 1 -> studentService.saveStudent(new Student("Mika","mik@gmail.com", LocalDate.of(2003,10,03)));
                case 2 -> System.out.println(studentService.getById(1L));
                case 3 -> System.out.println(studentService.getAllStudents());
                case 4 -> studentService.updateStudent(1L,new Student("Ademi","adem@gmail.com", LocalDate.of(2002,11,01)));
                case 5 -> studentService.deleteStud(1L);
                case 6 -> System.out.println(studentService.getStudentCourses(1L));
                case 7 -> System.out.println(studentService.getStudentBuEntollment(LocalDate.of(2003, 10, 03)));
                case 8 -> courseService.saveCourse(new Course("Java Spring","Sppting"));
                case 9 -> System.out.println(courseService.getById(1L));
                case 10 -> System.out.println(courseService.getAllCourses());
                case 11 -> courseService.updateCourse(1L,new Course("JS","CCS"));
                case 12 -> courseService.deleteCourse(1L);
                case 13 -> System.out.println(courseService.getCourseStudents(1L));
                case 14 -> courseService.assignStudentToCourse(1L,1L);
            }
        }
    }
}
