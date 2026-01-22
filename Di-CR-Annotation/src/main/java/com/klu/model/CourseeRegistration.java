package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CourseeRegistration {

    private int rollNo;
    private String studentName;
    private String courseName;
    private int semester;

    // Constructor
    public CourseeRegistration(@Value("101")int rollNo,@Value("Tarun") String studentName) {
        this.rollNo = rollNo;
        this.studentName = studentName;
    }
    @Value("FSAD")
    // Setter for courseName
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    @Value("4")
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