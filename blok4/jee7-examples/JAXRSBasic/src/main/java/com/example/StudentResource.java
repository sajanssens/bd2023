package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class StudentResource {

    private Long id;

    public StudentResource(Long id) { this.id = id; }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String student() { return new Student("MyId=" + id, "Subresource", 2000).toString(); }

}
