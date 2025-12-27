package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentId = 100;
    private static int courseId = 200;
    private static int enrollmentId = 300;

    public static int nextStudentId() { return ++studentId; }
    public static int nextCourseId() { return ++courseId; }
    public static int nextEnrollmentId() { return ++enrollmentId; }
}
