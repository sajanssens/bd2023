package javabd.labs.h14_collections;

import javabd.labs.h10_inheritance.Human;
import javabd.labs.h7_objectorientation.Gender;

import java.util.Objects;

public class PersonWrongHash extends Human {

    private String name;
    private int age;
    private Gender gender;

    public PersonWrongHash(String name, int age) {
        this(name, age, Gender.UNKNOWN);
    }

    public PersonWrongHash(String name, int age, Gender g) {
        this.name = name;
        this.age = age;
        this.gender = g;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PersonWrongHash)) return false;

        PersonWrongHash other = (PersonWrongHash) obj;
        return this.name.equals(other.name) && this.age == other.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age); // correct
        // return 1; // works correct but not efficient
        // return Objects.hash(name, age, gender); // incorrect: persons with same name and age will be added to hashset.
    }

    @Override
    public String greet() {
        return "Hello, my name is " + name + ". Nice to meet you!";
    }

}
