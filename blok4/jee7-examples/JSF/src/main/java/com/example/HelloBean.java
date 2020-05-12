package com.example;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

// http://localhost:8080/JSF
// http://localhost:8080/JSF/home.jsf
@RequestScoped
@Named
public class HelloBean {

    @Inject
    HelloService helloService;
	
    private String firstname;
    
    private String lastname;
    
    private String name;
    
    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String save() {
        name = firstname + " " + lastname;
        helloService.processHello(name);
        return "success";
    }
}