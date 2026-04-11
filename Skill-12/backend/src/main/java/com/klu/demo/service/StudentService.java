package com.klu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.demo.entity.Student;
import com.klu.demo.repository.*;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Add Student
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Update Student
    public Student updateStudent(Long id, Student newStudent) {
        Student student = repository.findById(id).orElseThrow();
        student.setName(newStudent.getName());
        student.setEmail(newStudent.getEmail());
        student.setCourse(newStudent.getCourse());
        return repository.save(student);
    }

    // Delete Student
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}