package javabd.examples.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    private List<? extends Employee> extendsEmployeeList;
    private List<? super Employee> superEmployeeList;

    private Person person = new Person();
    private Employee employee = new Employee();
    private Developer developer = new Developer();

    @Test
    public void testExtends() {
        //extendsEmployeeList = new ArrayList<Person>(); // Does not compile
        extendsEmployeeList = new ArrayList<Employee>();
        extendsEmployeeList = new ArrayList<Developer>();
    }

    @Test
    public void testSuper() {
        superEmployeeList = new ArrayList<Person>();
        superEmployeeList = new ArrayList<Employee>();
        //superEmployeeList = new ArrayList<Developer>(); // Does not compile
    }
}
