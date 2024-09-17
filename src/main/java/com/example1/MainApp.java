package com.example1;

import com.example.DAO.StudentDAO;
import com.example.entity.Student;

public class MainApp {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();


        Student student = new Student("Soundhur", "G", "soundhur.g@example.com");
        studentDAO.saveStudent(student);

        Student student1 = new Student("Varun","S","Varuns.s@example.com");


        Student retrievedStudent = studentDAO.getStudent(student.getId());
        System.out.println("Retrieved: " + retrievedStudent.getFirstName());

        studentDAO.updateStudent(student.getId(), "soundhurg@gmail.com");

        studentDAO.updateStudent(student1.getId(), "varuns@gmail.com");


        studentDAO.deleteStudent(student.getId());
    }
}

