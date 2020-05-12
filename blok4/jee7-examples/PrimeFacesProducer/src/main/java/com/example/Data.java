package com.example;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

public class Data {

	@Produces
	@Named("studs")
	public List<Student> students() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Wim", "Janssen", 1982));
		students.add(new Student("Ann", "Smit", 1982));
		students.add(new Student("Chloe", "Pieters", 1982));
		students.add(new Student("Peter", "Klaassen", 1982));
		return students;
	}

	@Produces
	@Named("studs2")
	public List<Student> students2() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Kees", "Smit", 1981));
		students.add(new Student("Sjakie", "Janssen", 1981));
		students.add(new Student("Mieke", "de Vries", 1981));
		students.add(new Student("Peter", "Besselink", 1981));
		return students;
	}

	@Produces
	@StudentData
	public List<Student> studentData() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Sjakie", "Janssen", 1983));
		students.add(new Student("Mieke", "de Vries", 1983));
		return students;
	}
}
