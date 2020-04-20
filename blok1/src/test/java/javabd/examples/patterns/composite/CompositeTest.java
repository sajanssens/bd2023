package javabd.examples.patterns.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositeTest {

    @Test
    public void testComposite() {
        Composite composite = new Composite();

        Developer developer = new Developer();
        composite.addEmployee(developer);
        Manager manager = new Manager();
        composite.addEmployee(manager);

        assertEquals("This is a developerThis is a manager", composite.retrieveDescription());
    }
}
