package com.example;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;

@Stateless
public class StudentDao {

    @PersistenceContext(unitName = "MyPersistenceUnit")
    private EntityManager entityManager;

    @PostConstruct
    public void post() {
        System.out.println("Postconstruct StudentManager");
    }

    @TransactionAttribute(REQUIRED)  // A.C.I.D.
    public void saveStudent1Valid() {
        entityManager.persist(new Student("Anna", 1967));
        entityManager.flush();
    }

    @TransactionAttribute(REQUIRES_NEW) // Use REQUIRED or REQUIRES_NEW
    public void saveStudent2TooLongName() {
        try {
            entityManager.persist(new Student("Jan Paul", 1973)); // name is too long, so insert will be rejected
            entityManager.flush();
        } catch (Exception e) {
            System.err.println("saveStudent2 threw exception! " + e.getMessage());
        }
    }

    @TransactionAttribute(REQUIRED)
    public void saveStudent12() {
        // studentDao.saveStudent1Valid();
        // studentDao.saveStudent2TooLongName();

        this.saveStudent1Valid(); // DONT DO THIS (pun intended!)
        this.saveStudent2TooLongName();
    }

    public void removeStudents() throws Exception {
        Query query = entityManager.createQuery("DELETE from Student");
        query.executeUpdate();
    }

    public List<Student> getStudents() throws Exception {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s from Student as s", Student.class);
        return query.getResultList();
    }
}
