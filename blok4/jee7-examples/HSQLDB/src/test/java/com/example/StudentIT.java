package com.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class StudentIT {
    @EJB
    private StudentEJB studentEJB;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Student.class.getPackage())
                .addAsResource("META-INF/persistence.xml");
    }

    @After
    public void tearDown() throws Exception {
        studentEJB.removeStudents();
    }

    @Test
    public void testGetStudents() throws Exception {
        studentEJB.addStudent(new Student("Wim", 1992));
        studentEJB.addStudent(new Student("Ann", 1995));
        assertEquals(2, studentEJB.getStudents().size());
    }

    @Test
    public void testGetZeroStudents() throws Exception {
        assertEquals(0, studentEJB.getStudents().size());
    }

    @Test
    public void testAddStudent() throws Exception {
        Student aron = new Student("Aron", 1985);
        studentEJB.addStudent(aron);
        assertEquals("Aron", studentEJB.getStudent(aron.getId()).getName());
    }
}
