package com.klu.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StudentController {
    @GetMapping("/message")
    public String getMessage() {
        return "FULL STACK APP WELCOME!!";
    }
    @GetMapping("/users")
    public List<String> getUsers() {
        return Arrays.asList("Tarun", "Ram", "Krishna");
    }
}
