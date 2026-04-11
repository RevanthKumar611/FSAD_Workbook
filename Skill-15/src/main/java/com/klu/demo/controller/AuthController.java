package com.klu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.demo.entity.User;
import com.klu.demo.repository.UserRepository;
import com.klu.demo.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = repo.findByUsername(user.getUsername());

        if (dbUser != null &&
            dbUser.getPassword().equals(user.getPassword())) {

            return jwtUtil.generateToken(
                    dbUser.getUsername(),
                    dbUser.getRole()
            );
        }

        return "Invalid credentials";
    }
}