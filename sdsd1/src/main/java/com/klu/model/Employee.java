package com.klu.model;
import javax.persistence.*;

@Entity
@Table(name="emp")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empid;
	private String empname;
	private double sal;
	//annotation for the class & object, must be like this only 
	@ManyToOne
	@JoinColumn(name="deptid") //Nothing but foreign key
	private Deptatment depatment;
	public void setEmpId(int id)
	{
		this.empid=id;
	}
	public int getEmpId()
	{
		return empid;
	}
	public void setEmpName(String name)
	{
		this.empname=name;
	}
	public String getEmpName()
	{
		return empname;
	}
	public void setSalary(double sal)
	{
		this.sal=sal;
	}
	public double getSalary()
	{
		return sal;
	}
	public void setDepatment(Deptatment dept)
	{
		this.depatment=dept;
	}
	public Deptatment getDepatment()
	{
		return depatment;
	}
}
