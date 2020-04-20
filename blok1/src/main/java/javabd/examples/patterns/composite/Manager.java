package javabd.examples.patterns.composite;

public class Manager implements Employee {
    @Override
    public String retrieveDescription() {
        return "This is a manager";
    }

}
