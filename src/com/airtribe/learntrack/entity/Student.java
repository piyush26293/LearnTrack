package com.airtribe.learntrack.entity;

public class Student extends Person {

    private String batch;
    private boolean active = true;

    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
    }

    public Student(int id, String firstName, String lastName, String batch) {
        this(id, firstName, lastName, null, batch);
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }

    // 🔥 IMPORTANT: This fixes display issues
    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + firstName + " " + lastName +
               ", Batch: " + batch +
               ", Status: " + (active ? "ACTIVE" : "INACTIVE");
    }
}
