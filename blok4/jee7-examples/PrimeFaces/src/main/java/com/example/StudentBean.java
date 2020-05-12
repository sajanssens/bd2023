package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StudentBean {

	private List<Student> students;

	private Student newStudent = new Student();

	public StudentBean() {
		students = new ArrayList<Student>();
		students.add(new Student("Wim", "Janssen", 1982));
		students.add(new Student("Ann", "Smit", 1982));
		students.add(new Student("Chloe", "Pieters", 1982));
		students.add(new Student("Peter", "Klaassen", 1982));

	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String save() {
		students.add(newStudent);
		newStudent = new Student();
		return "";
	}

	public Student getNewStudent() {
		return newStudent;
	}

	public void setNewStudent(Student newStudent) {
		this.newStudent = newStudent;
	}

}