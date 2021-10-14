package edu.isu.cs.cs2263.dto;

public class Course {

    private int number;
    private String subject;
    private String title;

    public Course(int number, String subject, String title) {
        this.number = number;
        this.subject = subject;
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
