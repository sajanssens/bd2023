package slides.h10_inheritance;

public class Employee {

    private long id;
    private String name;

    public long getSalary() {
        return -1;
    }

    public static String somethingStatic(){
        return "Employee";
    }

    // getters/setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
