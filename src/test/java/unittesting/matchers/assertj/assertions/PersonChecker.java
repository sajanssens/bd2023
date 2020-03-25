package unittesting.matchers.assertj.assertions;

import org.assertj.core.api.AbstractAssert;
import unittesting.matchers.Person;

public class PersonChecker extends AbstractAssert<PersonChecker, Person> {

    public PersonChecker(Person actual) {
        super(actual, PersonChecker.class);
    }

    public static PersonChecker assertThat(Person actual) {
        return new PersonChecker(actual);
    }

    public PersonChecker isDifferentPerson(Person expected) {
        // this check differs from Person.equals
        if (actualIsEqualTo(expected)) {
            failWithMessage("Expected <%s> but was <%s>", expected, actual);
        }
        return this;
    }

    public PersonChecker isSamePerson(Person expected) {
        if (!actualIsEqualTo(expected)) {
            failWithMessage("Expected <%s> but was <%s>", expected, actual);
        }
        return this;
    }

    private boolean actualIsEqualTo(Person expected) {
        return actual.getId() == expected.getId() &&
                actual.getAddress().equalsIgnoreCase(expected.getAddress()) &&
                actual.getName().equalsIgnoreCase(expected.getName());
    }
}
