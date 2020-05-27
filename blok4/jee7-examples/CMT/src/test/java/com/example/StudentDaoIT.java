package com.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class StudentDaoIT {

    @Inject
    private StudentDao studentDao;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(StudentService.class.getPackage())
                .addAsResource("META-INF/persistence.xml");
    }

    @After
    public void tearDown() throws Exception {
        studentDao.removeStudents();
    }

    @Test
    public void testGetStudents() throws Exception {
        studentDao.saveStudent1Valid();
        studentDao.saveStudent2TooLongName();
        /*
         * Always one, doesn't matter if REQUIRED or REQUIRES_NEW is used.
         *
         * Reason is that all the fancy annotation magic for the container isn't used
         * when calling the method with the annotation from within the same class.
         *
         * You need to call the method from within another class where you inject the StudentManager as an EJB.
         */
        assertEquals(1, studentDao.getStudents().size());
    }

    @Test
    public void testSaveStudent12() throws Exception {
        studentDao.saveStudent12();
        assertEquals(0, studentDao.getStudents().size());
    }
}
