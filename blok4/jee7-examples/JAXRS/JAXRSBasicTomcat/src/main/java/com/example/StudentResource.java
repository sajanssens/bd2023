package com.example;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("student")
public class StudentResource {
	
	// http://localhost:8080/JAXRSBasicTomcat/resources/student
	@GET
	public String helloStudent(){
		return "Hello student the time is: " + new Date();			
	}

}
