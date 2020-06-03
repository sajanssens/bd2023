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
public class StudentServiceIT {

    @Inject
    private StudentService studentService;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(StudentService.class.getPackage())
                .addAsResource("META-INF/persistence.xml");
    }

    @After
    public void tearDown() throws Exception {
        studentService.getStudentDao().removeStudents();
    }

    @Test
    public void testSave() throws Exception {
        studentService.save();
        assertEquals(1, studentService.getStudentDao().getStudents().size()); // when saveStudent2 == required, then this will fail, since the complete transaction will be rolled back
        assertEquals("Anna", studentService.getStudentDao().getStudents().get(0).getName());
    }

    @Test
    public void testSave12() throws Exception {
        studentService.save12();
        /*
         * Always zero, doesn't matter if REQUIRED or REQUIRES_NEW is used.
         *
         * Reason is that all the fancy annotation magic for the container isn't used
         * when calling the method with the annotation from within the same class.
         *
         * You need to call the method from within another class where you inject the StudentService as an EJB.
         */
        assertEquals(0, studentService.getStudentDao().getStudents().size());
    }
}
