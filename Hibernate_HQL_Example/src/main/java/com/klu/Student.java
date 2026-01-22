package com.klu;
import javax.persistence.*;
@Entity
@Table(name="student")
public class Student {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String name;
 private int marks;
 public Student() {}
 public Student(String name, int marks) {
 this.name = name;
 this.marks = marks;
 }
 public int getId() { return id; }
 public String getName() { return name; }
 public int getMarks() { return marks; }
 public void setName(String name) { this.name = name; }
 public void setMarks(int marks) { this.marks = marks; }
}