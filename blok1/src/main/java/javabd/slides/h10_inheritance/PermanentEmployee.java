package javabd.slides.h10_inheritance;

public class PermanentEmployee extends Employee {
    private int position;

    @Override
    public long getSalary() {
        return 2500 * position;
    }

    public static String somethingStatic(){
        return "PermanentEmployee";
    }

    // getters/setters

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
