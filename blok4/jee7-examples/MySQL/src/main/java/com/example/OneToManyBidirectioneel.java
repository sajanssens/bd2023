package com.example;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class OneToManyBidirectioneel {
    @PersistenceContext(unitName = "MyPersistenceUnit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    
    public void saveOrder(OrderContainer order) {
    	entityManager.persist(order);
    }
    
    public void saveItem(Item item) {
    	entityManager.persist(item);
    }
}
