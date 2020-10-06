package com.infosupport;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "com.infosupport.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
