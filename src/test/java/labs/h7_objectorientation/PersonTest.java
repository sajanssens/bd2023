package labs.h7_objectorientation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    @Test
    void testPerson() {
        Person p = new Person("Jan", 45);
        System.out.println(p.getGender());
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        p.haveBirthday();
        System.out.println(p.getAge());
        System.out.println(Person.numberOfPossibleGenders);
    }

    @Test
    void testOldPerson() {
        Person p = new Person("Jan", 129);
        p.haveBirthday();
        assertThrows(PersonDiedException.class, p::haveBirthday);
    }
}