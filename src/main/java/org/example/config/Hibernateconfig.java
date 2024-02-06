package org.example.config;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManagerFactory;
import org.example.entity.Course;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Hibernateconfig {
    public static EntityManagerFactory getEntity(){

        Properties properties = new Properties();
        properties.put(Environment.JAKARTA_JDBC_DRIVER,"org.postgresql.Driver");
        properties.put(Environment.JAKARTA_JDBC_URL,"jdbc:postgresql://localhost:5432/hibernate");
        properties.put(Environment.JAKARTA_JDBC_USER,"postgres");
        properties.put(Environment.JAKARTA_JDBC_PASSWORD,"2020");
        properties.put(Environment.HBM2DDL_AUTO,"update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL,"true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Course.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }

}
