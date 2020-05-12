package com.example;

import javax.validation.constraints.Size;

public class Student implements Cloneable {

	@Size(max=3, min=2, message="Length is not correct")
	private String firstname;
	@Size(min=3)
	private String lastname;
	
	private Integer yearOfBirth;
	
	
	
	public Student() {
		super();
	}
	public Student(String firstname, String lastname, int yearOfBirth) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.yearOfBirth = yearOfBirth;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	
	
}
