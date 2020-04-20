package unittesting.slides.matchers.hamcrest.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import unittesting.slides.matchers.Person;

public class PersonMatcher extends TypeSafeMatcher<Person> {

    private Person expectedPerson;

    private PersonMatcher(Person expectedPerson) {
        this.expectedPerson = expectedPerson;
    }

    @Factory
    public static PersonMatcher person(Person expectedPerson) {
        return new PersonMatcher(expectedPerson);
    }

    @Override
    protected boolean matchesSafely(Person current) {
        // this check differs from Person.equals
        return current.getName().equals(expectedPerson.getName()) &&
                current.getAddress().equals(expectedPerson.getAddress());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("A person  with name: ")
                .appendValue(expectedPerson.getName())
                .appendText(" and with address: ")
                .appendValue(expectedPerson.getAddress());
    }
}
