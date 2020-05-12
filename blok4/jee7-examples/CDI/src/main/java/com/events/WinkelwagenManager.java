package com.events;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Stateless
public class WinkelwagenManager {

	@Inject @Any 
	private Event<Item> itemEvent;
	
	public void addItem() {
		Item item = new Item();
		item.setName("JPA boek");
		itemEvent.fire(item);
	}
	
}
