package javabd.examples.patterns.factory;

public class Developer implements Employee {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public String retrieveDescription() {
        return "This is a developer";
    }

    @Override
    public String getName() {
        return name;
    }
}
