package javabd.examples.patterns.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeFactoryTest {

    @Test
    public void testManager() {
        Employee employee = EmployeeFactory.retrieveEmployee("manager", "Ann");
        assertEquals("Ann", employee.getName());
        assertTrue(employee instanceof Manager);
    }

    @Test
    public void testDeveloper() {
        Employee employee = EmployeeFactory.retrieveEmployee("developer", "Wim");
        assertEquals("Wim", employee.getName());
        assertTrue(employee instanceof Developer);
    }
}
