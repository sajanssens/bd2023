package javabd.examples.patterns.builder;

public class EmployeeBuilder {

    private String firstname;
    private String lastname;
    private String street;
    private String city;

    private String department;
    private String function;
    private double salary;

    public EmployeeBuilder(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public EmployeeBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public EmployeeBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public EmployeeBuilder withDepartment(String department) {
        this.department = department;
        return this;
    }

    public EmployeeBuilder withFunction(String function) {
        this.function = function;
        return this;
    }

    public EmployeeBuilder withSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public Employee build() {
        Employee employee = new Employee();
        employee.setFirstname(firstname);
        employee.setLastname(lastname);
        employee.setCity(city);
        employee.setStreet(street);
        employee.setDepartment(department);
        employee.setFunction(function);
        employee.setSalary(salary);
        return employee;
    }
}
