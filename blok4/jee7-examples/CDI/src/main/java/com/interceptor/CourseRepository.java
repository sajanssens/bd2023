package com.interceptor;

import javax.ejb.Stateless;

@Stateless
public class CourseRepository {

	@MeasureMethodDuration
	public void save() throws InterruptedException {
		System.out.println("Saving course");
		Thread.sleep(42L);
	}
	
	public void retrieve() throws InterruptedException {
		System.out.println("Retrieving course");
		Thread.sleep(650L);
	}
}
