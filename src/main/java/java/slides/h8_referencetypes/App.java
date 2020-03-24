package java.slides.h8_referencetypes;

public class App {

    public static void main(String[] args) {
        Person p = new Person();
        Object o = p;
        Employee e = new Employee();

        p = e; // works

        // e = p; // doesn't work
        e = (Employee) p; // works

        // e = o;
        e = (Employee) o; // compiles, but ClassCastException

        // Reflection
        e.getClass().getGenericSuperclass();
    }
}
