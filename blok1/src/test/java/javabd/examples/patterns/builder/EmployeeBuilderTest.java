package javabd.examples.patterns.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeBuilderTest {

    @Test
    public void testEmployeeBuilder() {
        Employee employee = new EmployeeBuilder("Chris", "Steffenson")
                .withCity("Amsterdam")
                .withStreet("Dorpsweg 10")
                .withDepartment("IT")
                .withFunction("Developer")
                .withSalary(2500.31)
                .build();

        assertEquals("Developer", employee.getFunction());
    }
}
