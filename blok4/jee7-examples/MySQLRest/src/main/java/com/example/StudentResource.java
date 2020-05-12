package com.example;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("")
public class StudentResource {
	// http://localhost:8080/MySQLRest/resources/student

	@EJB
	private StudentEJB studentEJB;

	// http://localhost:8080/MySQLRest/greeter
	@GET
	@Path("greeter")
	public String greet() {
		return "hello";
	}
	
	// Should be a POST :)
	// http://localhost:8080/MySQLRest/addStudent?name=johan&birthyear=1983
	@GET
	@Path("addStudent")
	public void addStudent(@QueryParam("name") String name, @QueryParam("birthyear") String birthyear)
			throws Exception {
		Student student = new Student(name, Integer.valueOf(birthyear));
		studentEJB.addStudent(student);
	}

	@GET
	@Path("student/{id}")
	public String getStudent(@PathParam("id") String id) throws NumberFormatException, Exception {
		return studentEJB.getStudent(Long.valueOf(id)).toString();
	}

	// http://localhost:8080/MySQLRest/students
	@GET
	@Path("students")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentContainer getStudents() throws Exception {
		List<Student> students = studentEJB.getStudents();
		StudentContainer container = new StudentContainer(students);
		return container;
	}
}
