package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    private String name;
    private int birthyear;

    public Student() {
    }

	public Student(String name, int birthyear) {
		super();
		this.name = name;
		this.birthyear = birthyear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthyear=" + birthyear + "]";
	}



}
