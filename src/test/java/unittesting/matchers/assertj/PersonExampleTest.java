package unittesting.matchers.assertj;

import org.junit.jupiter.api.Test;
import unittesting.matchers.Person;
import unittesting.matchers.assertj.assertions.PersonChecker;

public class PersonExampleTest {
    @Test
    public void testDifferentPersons() {
        Person amsterdammer = new Person(1, "Klaas", "Adam");
        Person rotterdammer = new Person(2, "Klaas", "Rotterdam");
        PersonChecker.assertThat(amsterdammer).isDifferentPerson(rotterdammer);
    }

    @Test
    public void testSamePersons() {
        Person amsterdammer1 = new Person(1, "Klaas", "Adam");
        Person amsterdammer2 = new Person(1, "Klaas", "Adam");
        PersonChecker.assertThat(amsterdammer1).isSamePerson(amsterdammer2);
    }
}
