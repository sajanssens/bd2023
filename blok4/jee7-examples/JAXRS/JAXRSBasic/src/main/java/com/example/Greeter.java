package com.example;

import javax.ejb.Stateless;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

@Stateless
public class Greeter {

    public String hello() {
        return "Goedemorgen in Utrecht.";
    }

    @Produces
    public Student getSpecialStudent(@New Student s) {
        s.setFirstname("Ferry");
        s.setLastname("Special");
        return s;
    }
}
