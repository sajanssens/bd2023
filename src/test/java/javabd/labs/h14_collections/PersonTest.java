package javabd.labs.h14_collections;


import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

class PersonTest {

    @Test
    void testHistory() {
        Person p1 = new Person("Jan", 45);

        p1.printHistory();

        p1.addHistory("Born");
        p1.addHistory("Went to school");
        p1.addHistory("Got a job");
        p1.addHistory("Got married");

        p1.printHistory();
    }

    @Test
    void testHashcodes() {
        HashSet<Person> persons = new HashSet<>();

        persons.add(new Person("Jan", 45));
        persons.add(new Person("Jan", 45));
        persons.add(new Person("Piet", 44));
        persons.add(new Person("Piet", 44));
        persons.add(new Person("Joris", 33));
        persons.add(new Person("Joris", 33));
        persons.add(new Person("Corneel", 21));
        persons.add(new Person("Corneel", 21));

        assertThat(persons.size(), is(4));

        for (Person person : persons) {
            System.out.println(person.hashCode());
        }
    }
}