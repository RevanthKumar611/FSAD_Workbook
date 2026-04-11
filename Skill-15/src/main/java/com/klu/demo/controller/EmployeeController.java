package com.klu.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @GetMapping("/admin/add")
    public String addEmployee() {
        return "ADMIN: Added employee";
    }

    @DeleteMapping("/admin/delete")
    public String deleteEmployee() {
        return "ADMIN: Deleted employee";
    }

    @GetMapping("/employee/profile")
    public String profile() {
        return "EMPLOYEE PROFILE";
    }
}