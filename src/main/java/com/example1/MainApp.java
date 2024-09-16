package com.example1;

import com.example.DAO.StudentDAO;
import com.example.entity.Student;

public class MainApp {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Create a new student
        Student student = new Student("Soundhur", "G", "soundhur.g@example.com");
        studentDAO.saveStudent(student);

        // Retrieve the student by ID
        Student retrievedStudent = studentDAO.getStudent(student.getId());
        System.out.println("Retrieved: " + retrievedStudent.getFirstName());

        // Update the student's email
        studentDAO.updateStudent(student.getId(), "soundhurg@gmail.com");

        // Delete the student
        //studentDAO.deleteStudent(student.getId());
    }
}

