package com.klu.model;
import javax.persistence.*;
import java.util.*;
@Entity
@Table(name="dept") //HQL - queries will be implemented only query not on tables
public class Deptatment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deptid;
	private String deptname;
	
	@OneToMany(mappedBy="depatment",cascade=CascadeType.ALL)
	private List<Employee> emps;
	
	public void setDeptId(int deptid)
	{
		this.deptid=deptid;
	}
	public int getDeptId()
	{
		return deptid;
	}
	public void setDeptName(String name)
	{
		this.deptname=name;
	}
	public String getDeptName()
	{
		return deptname;
	}
}
