package com.airtribe.learntrack.entity;

public class Course {
    private int id;
    private String name;
    private int durationWeeks;
    private boolean active = true;

    public Course(int id, String name, int durationWeeks) {
        this.id = id;
        this.name = name;
        this.durationWeeks = durationWeeks;
    }

    public int getId() { return id; }
    public boolean isActive() { return active; }
    public void deactivate() { this.active = false; }
}
