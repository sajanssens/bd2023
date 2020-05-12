package com.example;

import javax.ejb.Stateless;

@Stateless
public class PrintService {

	public void print(String message) {
		System.out.println("Printing: " + message);
	}
}
