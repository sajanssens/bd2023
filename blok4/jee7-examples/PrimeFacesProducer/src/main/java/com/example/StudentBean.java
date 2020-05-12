package com.example;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

// localhost:8080/PrimeFacesProducer
@ManagedBean
@SessionScoped
public class StudentBean {

	@Inject
	@Named("studs2")
//	@StudentData // alternatively
	private List<Student> students;
	private Student newStudent = new Student();

	public StudentBean() {	}

	public List<Student> getStudents() {
		return students;
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