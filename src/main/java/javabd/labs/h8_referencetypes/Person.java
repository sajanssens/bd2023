package javabd.labs.h8_referencetypes;

import javabd.labs.h7_objectorientation.Gender;
import javabd.labs.h7_objectorientation.PersonDiedException;

public class Person {
    private String name;
    private int age;
    private Gender gender;

    public static final int numberOfPossibleGenders = 3;

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
        return this.name.equals(other.getName()) &&
                this.age == other.getAge() &&
                this.gender.equals(other.getGender());
    }

    @Override // B
    public int hashCode() {
        return name.hashCode() * age * gender.hashCode();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize called.");
    }
}
