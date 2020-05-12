package com.example;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateful
public class StudentEJB {

    @PersistenceContext(unitName = "MyPersistenceUnit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void addStudent(Student student) throws Exception {
        entityManager.persist(student);
    }
    
    public Student getStudent(Long id) throws Exception {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s from Student as s where s.id = :id", Student.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public void deleteStudent(Student student) throws Exception {
        entityManager.remove(student);
    }

    @SuppressWarnings("unchecked")
	public List<Student> getStudents() throws Exception {
        Query query = entityManager.createQuery("SELECT s from Student as s");
        return query.getResultList();
    }
    
    public void removeStudents() throws Exception {
        Query query = entityManager.createQuery("DELETE from Student");
        query.executeUpdate();
    }

}
