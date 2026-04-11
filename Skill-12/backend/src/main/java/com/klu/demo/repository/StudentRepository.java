package com.klu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.demo.entity.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}