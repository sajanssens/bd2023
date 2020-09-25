package javabd.labs.h14_collections;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PersonWrongHashTest {

    @Test
    void testHashcodes() {
        HashSet<PersonWrongHash> persons = new HashSet<>();

        PersonWrongHash jan = new PersonWrongHash("Jan", 45);
        PersonWrongHash sameJan = new PersonWrongHash("Jan", 45);

        persons.add(jan);
        persons.add(sameJan);

        assertEquals(jan, sameJan); // they are equal, but,
        assertThat(persons.size(), is(2)); // this is not good; equal persons should not be present in a set.
    }

}
