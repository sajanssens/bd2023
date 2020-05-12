package com.example;

import javax.persistence.EntityManager;

public class Example {

	public static void main(String[] args) {
		Student student = new Student("Anne", 1954);

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(student);
		
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}

}
