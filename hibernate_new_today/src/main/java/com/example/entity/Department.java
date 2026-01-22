package com.example.entity; 
import javax.persistence.*; 
@Entity 
@Table(name="dept") 
public class Department { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int deptId; 
    private String deptName; 
    public Department() {} 
    public Department(String deptName) { 
        this.deptName = deptName; 
    } 
    public int getDeptId() { return deptId; } 
    public String getDeptName() { return deptName; } 
    public void setDeptName(String deptName) { this.deptName = deptName; } 
}