package com.airtribe.learntrack.ui;

import java.util.Scanner;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;

import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;

import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import com.airtribe.learntrack.exception.EntityNotFoundException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        boolean running = true;

        System.out.println("===== Welcome to LearnTrack =====");

        while (running) {

            System.out.println("\nMain Menu");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");

            int choice = InputValidator.readInt(sc, "Enter your choice: ");

            switch (choice) {

                case 1:
                    studentMenu(sc, studentService);
                    break;

                case 2:
                    courseMenu(sc, courseService);
                    break;

                case 3:
                    enrollmentMenu(sc, studentService, courseService, enrollmentService, sc);
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting LearnTrack. Thank you!");
                    break;

                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }

        sc.close();
    }

    // ================= STUDENT MENU =================
    private static void studentMenu(Scanner sc, StudentService studentService) {

        boolean back = false;

        while (!back) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("0. Back");

            int choice = InputValidator.readInt(sc, "Enter choice: ");

            try {
                switch (choice) {

                    case 1:
                        String fn = InputValidator.readString(sc, "First Name: ");
                        String ln = InputValidator.readString(sc, "Last Name: ");
                        String batch = InputValidator.readString(sc, "Batch: ");

                        Student s = new Student(
                                IdGenerator.nextStudentId(),
                                fn,
                                ln,
                                batch
                        );

                        studentService.addStudent(s);
                        System.out.println("✅ Student added successfully");
                        break;

                    case 2:
                        studentService.listStudents();
                        break;

                    case 3:
                        int id = InputValidator.readInt(sc, "Enter Student ID: ");
                        Student found = studentService.findById(id);
                        System.out.println("Found: " + found.getDisplayName());
                        break;

                    case 4:
                        int did = InputValidator.readInt(sc, "Enter Student ID to deactivate: ");
                        Student st = studentService.findById(did);
                        st.deactivate();
                        System.out.println("✅ Student deactivated");
                        break;

                    case 0:
                        back = true;
                        break;

                    default:
                        System.out.println("❌ Invalid option");
                }
            } catch (EntityNotFoundException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    // ================= COURSE MENU =================
    private static void courseMenu(Scanner sc, CourseService courseService) {

        boolean back = false;

        while (!back) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Deactivate Course");
            System.out.println("0. Back");

            int choice = InputValidator.readInt(sc, "Enter choice: ");

            switch (choice) {

                case 1:
                    String name = InputValidator.readString(sc, "Course Name: ");
                    int weeks = InputValidator.readInt(sc, "Duration (weeks): ");

                    Course c = new Course(
                            IdGenerator.nextCourseId(),
                            name,
                            weeks
                    );

                    courseService.addCourse(c);
                    System.out.println("✅ Course added");
                    break;

                case 2:
                    courseService.listCourses();
                    break;

                case 3:
                    System.out.println("❌ Deactivation by ID can be added later");
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println("❌ Invalid option");
            }
        }
    }

    // ================= ENROLLMENT MENU =================
    private static void enrollmentMenu(
            Scanner sc,
            StudentService studentService,
            CourseService courseService,
            EnrollmentService enrollmentService,
            Scanner scanner) {

        boolean back = false;

        while (!back) {
            System.out.println("\n--- Enrollment Management ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View Enrollments by Student");
            System.out.println("0. Back");

            int choice = InputValidator.readInt(sc, "Enter choice: ");

            try {
                switch (choice) {

                    case 1:
                        int sid = InputValidator.readInt(sc, "Student ID: ");
                        int cid = InputValidator.readInt(sc, "Course ID: ");

                        // Validate student existence
                        // Validate student and course existence
                        studentService.findById(sid);
                        courseService.findById(cid);


                        Enrollment e = new Enrollment(
                                IdGenerator.nextEnrollmentId(),
                                sid,
                                cid
                        );

                        enrollmentService.enroll(e);
                        System.out.println("✅ Enrollment successful");
                        break;

                    case 2:
                        int sid2 = InputValidator.readInt(sc, "Student ID: ");
                        enrollmentService.listEnrollments(sid2);
                        break;

                    case 0:
                        back = true;
                        break;

                    default:
                        System.out.println("❌ Invalid option");
                }
            } catch (EntityNotFoundException ex) {
                System.out.println("❌ " + ex.getMessage());
            }
        }
    }
}
