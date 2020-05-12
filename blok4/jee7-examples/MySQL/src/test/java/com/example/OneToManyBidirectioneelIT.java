package com.example;

import junit.framework.TestCase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RunWith(Arquillian.class)
public class OneToManyBidirectioneelIT extends TestCase {


	@Inject
	private OneToManyBidirectioneel oneToMany;

	@Deployment
	public static WebArchive createDeployment() {
		WebArchive archive = ShrinkWrap.create(WebArchive.class)
				.addPackage(OneToOne.class.getPackage())
				.addAsResource("META-INF/persistence.xml");

		System.out.println(archive.toString(true));
		return archive;
	}

	/**
	 * Komt niet goed in de database te staan
	 */
	@Test
	public void testPersistItem(){		
		List<Item> items = new ArrayList<Item>();
		Item item1 = new Item();
		item1.setItemname("Fiets 1 Persist Item");
		items.add(item1);
		oneToMany.saveItem(item1);

		
		Item item2 = new Item();
		item2.setItemname("Fiets 2 Persist Item");
		items.add(item2);
		oneToMany.saveItem(item2);		

		OrderContainer order = new OrderContainer();
		order.setOrdernaam("Bestelling Persist Item");
		order.setItems(items);
		oneToMany.saveOrder(order);		
	}
	

	@Test
	public void testPersistOrder(){
		OrderContainer order = new OrderContainer();
		order.setOrdernaam("Bestelling Persist Order");
		
		oneToMany.saveOrder(order);
		
		Item item1 = new Item();
		item1.setItemname("Fiets 1 Persist Order");
		//items.add(item1);
		item1.setOrder(order);
		oneToMany.saveItem(item1);
		
		Item item2 = new Item();
		item2.setItemname("Fiets 2 Persist Order");
		//items.add(item2);
		item2.setOrder(order);
		oneToMany.saveItem(item2);
	}


}
