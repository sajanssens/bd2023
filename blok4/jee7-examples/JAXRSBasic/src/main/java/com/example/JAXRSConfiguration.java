package com.example;

import com.github.phillipkruger.apiee.ApieeService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(StudentsResource.class);
        classes.add(ApieeService.class);

        return classes;
    }
}
