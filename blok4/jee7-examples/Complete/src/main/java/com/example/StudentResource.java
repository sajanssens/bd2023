package com.example;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;


/*
 * Don't forget to create a 'test' schema in MySQL workbench before running the application.
 * The following command can be used: create database test
 */
@Path("studentresource")
public class StudentResource {

	private static final Logger LOGGER = Logger.getLogger(StudentResource.class.getName());

	@Inject // can't use @EJB in a JAX-RS class
	private StudentEJB studentEJB;

	// http://localhost:9080/Complete/resources/studentresource/greeter
	@GET
	@Path("greeter")
	public String greet() {
		LOGGER.info("greeter path is used" );
		return "hello";
	}

	// http://localhost:9080/Complete/resources/studentresource/addStudent?name=Pieters&birthyear=1980
	// Should be a POST :)
	@GET
	@Path("addStudent")
	public void addStudent(@QueryParam("name") String name, @QueryParam("birthyear") String birthyear)
			throws Exception {
		LOGGER.info("addStudent path is used" );
		Student student = new Student(name, Integer.valueOf(birthyear));
		studentEJB.addStudent(student);
	}

	// http://localhost:9080/Complete/resources/studentresource/student/1
	@GET
	@Path("student/{id}")
	public String getStudent(@PathParam("id") String id) throws NumberFormatException, Exception {
		LOGGER.info("getStudent path is used" );
		return studentEJB.getStudent(Long.valueOf(id)).toString();
	}

	// http://localhost:9080/Complete/resources/studentresource/students
	@GET
	@Path("students")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentContainer getStudents() throws Exception {
		LOGGER.info("getStudents path is used" );
		List<Student> students = studentEJB.getStudents();
		StudentContainer container = new StudentContainer(students);
		return container;
	}
}
