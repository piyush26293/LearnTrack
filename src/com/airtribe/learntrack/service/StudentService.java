package com.airtribe.learntrack.service;

import java.util.ArrayList;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public Student findById(int id) throws EntityNotFoundException {
        for (Student s : students)
            if (s.getId() == id) return s;
        throw new EntityNotFoundException("Student not found");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
    
        for (Student s : students) {
            System.out.println(s); // calls toString()
        }
    }
    
}
