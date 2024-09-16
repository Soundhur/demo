package com.example.DAO;

import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {

    private final SessionFactory factory;

    public StudentDAO() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    // Create a new student
    public void saveStudent(Student student) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    // Read a student by id
    public Student getStudent(int id) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        } finally {
            session.close();
        }
    }

    // Update a student's details
    public void updateStudent(int id, String newEmail) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                student.setEmail(newEmail);
            }
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    // Delete a student by id
    public void deleteStudent(int id) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            }
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}

