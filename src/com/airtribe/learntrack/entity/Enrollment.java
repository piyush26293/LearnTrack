package com.airtribe.learntrack.entity;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private String status;

    public Enrollment(int id, int studentId, int courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = "ACTIVE";
    }

    public int getStudentId() { return studentId; }
    public void setStatus(String status) { this.status = status; }
}
