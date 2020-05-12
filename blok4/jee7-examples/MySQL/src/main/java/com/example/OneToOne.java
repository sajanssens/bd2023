package com.example;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class OneToOne {
    @PersistenceContext(unitName = "MyPersistenceUnit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    
    public void saveAddress(Address address) {
    	entityManager.persist(address);
    }
    
    public void saveContact(Contact contact) {
    	entityManager.persist(contact);
    }
}
