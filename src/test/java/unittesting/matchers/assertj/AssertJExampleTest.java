package unittesting.matchers.assertj;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import unittesting.matchers.Person;
import unittesting.matchers.assertj.assertions.NotANumberChecker;
import unittesting.matchers.assertj.assertions.PersonChecker;

import java.util.List;

import static java.lang.Math.sqrt;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExampleTest {
    @Test
    void testStringArrayList() {
        List<String> abc = asList("a", "b", "c");

        assertThat(abc).hasSize(3)
                .contains("a")
                .containsAnyOf("b")
                .containsAnyOf("a", "b", "c", "d")
                .containsExactly("a", "b", "c")
                .containsAll(asList("a", "b"))
                .containsOnly("a", "b", "c");
    }

    @Test
    public void testNotANumber() {
        NotANumberChecker.assertThat(sqrt(-1)).isNotANumber();
    }

    @Test
    void testMultiplePersonsChecks() {
        Person amsterdammer = new Person(1, "Klaas", "Adam");
        Person rotterdammer = new Person(2, "Klaas", "Rotterdam");

        PersonChecker.assertThat(amsterdammer).isDifferentPerson(rotterdammer);
    }

    @Test
    public void testSoftAssertions() {
        Person amsKlaas = new Person(1, "Klaas", "Adam");
        Person rotKlaas = new Person(2, "Klaas", "Rotterdam");

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(amsKlaas.getId()).isEqualTo(rotKlaas.getId()); // wrong
        softAssertions.assertThat(amsKlaas.getName()).isEqualTo(rotKlaas.getName());
        softAssertions.assertThat(amsKlaas.getAddress()).isEqualTo(rotKlaas.getAddress()); // wrong

        // Breaks tests softAssertions.assertAll();
    }
}
