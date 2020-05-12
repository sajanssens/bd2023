package com.example;

import javax.ejb.Stateless;

@Stateless
public class HelloService {

	public void processHello(String name) {
		System.out.println("Executing some very important work for " + name);
	}
}
