package javabd.examples.patterns.factory;

public class Manager implements Employee {
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public String retrieveDescription() {
        return "This is a manager";
    }

    @Override
    public String getName() {
        return name;
    }
}
