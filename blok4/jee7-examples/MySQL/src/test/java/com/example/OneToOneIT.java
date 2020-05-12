package com.example;

import junit.framework.TestCase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class OneToOneIT extends TestCase {
	@Inject
	private OneToOne oneToOne;

	@Deployment
	public static WebArchive createDeployment() {
		WebArchive archive = ShrinkWrap.create(WebArchive.class)
				.addPackage(OneToOne.class.getPackage())
				.addAsResource("META-INF/persistence.xml");

		System.out.println(archive.toString(true));
		return archive;
	}

	
	@Test
	public void testPersistContact(){
		Contact contact = new Contact();
		contact.setName("Wim Persist Contact");
		Address address = new Address();
		address.setStreet("Utrecht Persist Contact");
		contact.setAddress(address);
		
		oneToOne.saveContact(contact);	
	}
	
	@Test
	public void testPersistAddress(){
		Contact contact = new Contact();
		contact.setName("Wim Persist Address");
		Address address = new Address();
		address.setStreet("Utrecht Persist Address");
		contact.setAddress(address);
		
		oneToOne.saveAddress(address);	
	}
	
	@Test
	public void testPersistAddressFixed(){
		Contact contact = new Contact();
		contact.setName("Wim Persist Address fixed");
		Address address = new Address();
		address.setStreet("Utrecht Persist Address fixed");
		contact.setAddress(address);
		
		address.setContact(contact); //Fix
		oneToOne.saveAddress(address);	
	}

}
