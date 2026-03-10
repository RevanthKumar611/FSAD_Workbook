package com.klu.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.klu.demo.exception.StudentNotFoundException;
import com.klu.demo.exception.InvalidInputException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public String getStudent(@PathVariable int id) {

        if(id <= 0) {
            throw new InvalidInputException("Invalid student ID");
        }

        if(id != 101) {
            throw new StudentNotFoundException("Student not found with ID " + id);
        }

        return "Student Found : Tarun (CSE AIML)";
    }
}