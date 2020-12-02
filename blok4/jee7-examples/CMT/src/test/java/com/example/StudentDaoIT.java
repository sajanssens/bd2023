package com.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
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
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
    }

    @Test
    public void testSaveStudentsSameTransaction() throws Exception {
        int before = studentDao.getStudents().size();

        studentDao.saveStudent1Valid();
        studentDao.saveStudent2TooLongNameSameTransaction(); // mislukt == rollback alles

        int after = studentDao.getStudents().size();

        assertEquals(0, after - before);
    }

    @Test
    public void testSaveStudentsDifferentTransactions() throws Exception {
        int before = studentDao.getStudents().size();

        studentDao.saveStudent1Valid();
        studentDao.saveStudent2TooLongNameInANewTransaction(); // mislukt == rollback student2

        int after = studentDao.getStudents().size();

        assertEquals(1, after - before);
    }

    @Test
    public void testSaveStudent12() throws Exception {
        int before = studentDao.getStudents().size();
        studentDao.saveStudent12();
        int after = studentDao.getStudents().size();

        assertEquals(0, after - before);
    }
}
