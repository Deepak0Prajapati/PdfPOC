package com.Task.MODEL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String department;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Student(int id, String name, String department, String message) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.message = message;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", department=" + department + ", message=" + message + "]";
	}

	
}
