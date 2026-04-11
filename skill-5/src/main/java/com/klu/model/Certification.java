package com.klu.model;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 101;
    private String name = "Java Spring Certification";
    private String dateOfCompletion = "2026-03-01";

    public String toString() {
        return "Certification ID: " + id +
               ", Name: " + name +
               ", Date: " + dateOfCompletion;
    }
}