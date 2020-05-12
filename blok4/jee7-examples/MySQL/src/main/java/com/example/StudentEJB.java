package com.example;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateful
public class StudentEJB {

    @PersistenceContext(unitName = "MyPersistenceUnit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    
    @EJB
    private PrintService printStudent;

    public void addStudent(Student student) throws Exception {
    	printStudent.print("Adding student " + student.getName());
        entityManager.persist(student);
    }
    
    public Student getStudent(Long id) throws Exception {
    	printStudent.print("Get student " + id);
        Query query = entityManager.createQuery("SELECT s from Student as s where s.id = :id");
        query.setParameter("id", id);
        return (Student) query.getSingleResult();
    }

    public void deleteStudent(Student student) throws Exception {
        entityManager.remove(student);
    }

    public List<Student> getStudents() throws Exception {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s from Student as s", Student.class);
        return query.getResultList();
    }
    
    public void removeStudents() throws Exception {
        Query query = entityManager.createQuery("DELETE from Student");
        query.executeUpdate();
    }

}
