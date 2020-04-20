package javabd.examples.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Employee {
    List<Employee> employeeList = new ArrayList<>();

    @Override
    public String retrieveDescription() {
        String description = "";
        for(Employee employee : employeeList) {
            description += employee.retrieveDescription();
        }
        return  description;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
}
