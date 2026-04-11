package com.klu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}