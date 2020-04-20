package javabd.examples.patterns.composite;

public class Developer implements Employee {
    @Override
    public String retrieveDescription() {
        return "This is a developer";
    }

}
