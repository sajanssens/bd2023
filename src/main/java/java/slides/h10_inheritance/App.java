package java.slides.h10_inheritance;

public class App {
    public static void main(String[] args) {
        Employee employee;
        PermanentEmployee permanentEmployee = new PermanentEmployee();
        permanentEmployee.setPosition(2);
        employee = permanentEmployee;
        System.out.println(employee.getSalary()); // from subclass

        System.out.println(employee.somethingStatic()); // from superclass
        System.out.println(permanentEmployee.somethingStatic()); // from subclass
    }
}
