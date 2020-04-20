package javabd.labs.h11_specialclasses;

import javabd.labs.h7_objectorientation.Gender;
import javabd.labs.h7_objectorientation.PersonDiedException;
import javabd.labs.h10_inheritance.Human;

public class Person extends Human {
    public static final int numberOfPossibleGenders = 3;

    private String name;
    private int age;
    private Gender gender;
    private HistoryRecord[] history = new HistoryRecord[50];
    private int historyIndex = 0;

    public Person(String name, int age) {
        this(name, age, Gender.UNKNOWN);
    }

    public Person(String name, int age, Gender g) {
        this.name = name;
        this.age = age;
        this.gender = g;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void birthday() {
        if (this.age >= 130) throw new PersonDiedException();
        this.age++;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (" + age + ") is " + gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) return false;

        Person other = (Person) obj;
        return this.name.equals(other.getName()) && this.age == other.getAge() && this.gender.equals(other.getGender());
    }

    @Override
    public int hashCode() {
        return name.hashCode() * age * gender.hashCode();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize called.");
        super.finalize();
    }

    @Override
    public String greet() {
        return "Hello, my name is " + name + ". Nice to meet you!";
    }

    public void addHistory(String descr) {
        this.history[historyIndex++] = new HistoryRecord(descr);
    }

    public void printHistory() {
        for (int i = 0; i < historyIndex; i++) {
            System.out.println(history[i]);
        }
    }

    private class HistoryRecord {
        String description;

        public HistoryRecord(String descr) {
            this.description = descr;
        }

        @Override
        public String toString() { return description; }
    }

    public Human createSubHuman() {
        return new Human() {
            @Override
            public String greet() { return "Sub is the best."; }
        };
    }

}
