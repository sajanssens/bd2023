package com.events;

import javax.enterprise.event.Observes;

public class InventoryListener {
	public void listen(@Observes Item event) {
		System.out.println("InventoryListener " + event.getName());
	}
}
