package com.airtribe.learntrack.service;

import java.util.ArrayList;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseService {
    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void listCourses() {
        courses.forEach(c -> System.out.println("Course ID: " + c.getId()));
    }
    public Course findById(int id) throws EntityNotFoundException {
    for (Course c : courses) {
        if (c.getId() == id) return c;
    }
    throw new EntityNotFoundException("Course not found");
}

}
