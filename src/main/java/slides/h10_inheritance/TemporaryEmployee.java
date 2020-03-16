package slides.h10_inheritance;

public class TemporaryEmployee extends Employee {
    private int numberOfHours;

    public long getSalary() {
        return numberOfHours * 40;
    }

    public String toString() {
        return getId() + " - " + getName();
    }

    // getters/setters

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }
}
