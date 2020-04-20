package javabd.examples.patterns.factory;

public class EmployeeFactory {
    public static Employee retrieveEmployee(String type, String name) {
        if ("manager".equals(type)) {
            return new Manager(name);
        } else if ("developer".equals(type)) {
            return new Developer(name);
        }
        return null;
    }
}
