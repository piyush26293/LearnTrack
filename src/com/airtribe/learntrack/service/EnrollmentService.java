package com.airtribe.learntrack.service;

import java.util.ArrayList;
import com.airtribe.learntrack.entity.Enrollment;

public class EnrollmentService {
    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public void enroll(Enrollment e) {
        enrollments.add(e);
    }

    public void listEnrollments(int studentId) {
        boolean found = false;
    
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                System.out.println("Enrollment ID: " + e.getStudentId() +
                                   ", Course ID: " + e.getStudentId());
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("No enrollments found for this student.");
        }
    }
    
}

