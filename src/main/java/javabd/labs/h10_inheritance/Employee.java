package javabd.labs.h10_inheritance;

public class Employee extends Person {
    public Employee(String name, int age) {
        super(name, age);
    }

    @Override
    public String greet() {
        return "I'm tired of working. This is inhuman!";
    }
}
