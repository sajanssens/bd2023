package javabd.labs.h10_inheritance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HumanTest {

    @Test
    void test() {
        List<Human> humans = new ArrayList<>();
        Android android = new Android();

        humans.add(new Person("Jan", 45));
        humans.add(android);
        humans.add(new Teacher("Brammetje Baas", 25));
        humans.add(new Employee("Jim Doe", 50));

        android.charge(30);
        android.charge(100);

        for (Human human : humans) {
            System.out.println(human.greet());
        }
    }
}