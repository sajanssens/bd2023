package com.example;

import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

// http://localhost:9080/JAXRSBasic/resources/students
@Path("students")
@Api("students")
public class StudentsResource {

    @Inject
    private Greeter greeter;
    private StudentContainer studentContainer = new StudentContainer();

    @Inject // met @New hier overschrijf je een eventuele scope van student zodat je altijd een nieuwe krijgt
    private Student special;

    @GET @Path("special")
    @Produces(MediaType.APPLICATION_JSON)
    public Student special() { return special; }

    @GET @Path("greeter")
    public String helloGreeter() { return greeter.hello(); }

    @GET @Path("date")
    public String helloStudent() { return "Hello student the time is: " + new Date(); }

    @GET @Path("plain")
    public StudentContainer studentPlain() {
        return studentContainer;
    }

    @GET @Path("xml")
    @Produces(MediaType.APPLICATION_XML)
    public StudentContainer studentXML() {
        return studentContainer;
    }

    @GET @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentContainer studentJSON() {
        return studentContainer;
    }

    @Path("{id}")
    public StudentResource student(@PathParam("id") Long id) { return new StudentResource(id); }
}
