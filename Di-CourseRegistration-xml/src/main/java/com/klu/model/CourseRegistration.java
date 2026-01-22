package com.klu.model;

public class CourseRegistration {

    private int rollNo;
    private String studentName;
    private String courseName;
    private int semester;

    // Constructor
    public CourseRegistration(int rollNo, String studentName) {
        this.rollNo = rollNo;
        this.studentName = studentName;
    }

    // Setter for courseName
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Setter for semester
    public void setSemester(int semester) {
        this.semester = semester;
    }

    // Display method
    public void display() {
        System.out.println("Roll No      : " + rollNo);
        System.out.println("Student Name : " + studentName);
        System.out.println("Course Name  : " + courseName);
        System.out.println("Semester     : " + semester);
    }
}