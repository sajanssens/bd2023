package com.events;

import javax.enterprise.event.Observes;

public class CustomerListener {
	public void listen(@Observes Item event) {
		System.out.println("CustomerListener " + event.getName());
	}
}
