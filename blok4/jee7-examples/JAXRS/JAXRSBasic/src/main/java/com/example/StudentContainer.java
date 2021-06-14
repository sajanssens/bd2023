package com.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class StudentContainer {

    @XmlElement private List<Student> students;

    public StudentContainer() {
        createStudents();
    }

    public void createStudents() {
        students = new ArrayList<>();
        students.add(new Student("Wim", "Janssen", 1982));
        students.add(new Student("Ann", "Smit", 1981));
        students.add(new Student("Chloe", "Pieters", 1988));
        students.add(new Student("Peter", "Klaassen", 1978));
    }
}
