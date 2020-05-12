package com.example;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentContainer {
    @XmlElement
	private List<Student> students;

    public StudentContainer() {
	}

    public StudentContainer(List<Student> students) {
    	this.students = students;
    }
}
