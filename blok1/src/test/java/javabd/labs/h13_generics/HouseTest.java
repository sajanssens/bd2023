package javabd.labs.h13_generics;

import javabd.labs.h10_inheritance.Android;
import javabd.labs.h10_inheritance.Person;
import org.junit.jupiter.api.Test;

class HouseTest {
    @Test
    void testHouse() {
        House<Android> ha = new House<>(new Android());
        System.out.println(ha);

        House<Person> hp = new House<>(new Person("Piet", 10));
        System.out.println(hp);
    }
}