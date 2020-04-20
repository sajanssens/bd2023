package unittesting.labs.lab1.stringadder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("StringAdder add(String numbers) tests")
class StringAdderWithDisplayTests {

    private StringAdder stringAdder;
    private static final String EMPTY_STRING = "";

    @BeforeEach
    public void setUp() {
        stringAdder = new StringAdder();
    }

    @Test
    @DisplayName("Given as input an empty string When add is called Then the result is 0")
    void whenAddIsCalledWithEmptyStringItShouldReturnZero() {
        assertEquals(0, stringAdder.add(EMPTY_STRING));
    }

    @Test
    @DisplayName("Given as input one as string When add is called Then the result is 1")
    void whenAddIsCalledWithStringOneItShouldReturnIntOne() {
        assertEquals(1, stringAdder.add("1"));
    }

    @Test
    @DisplayName("Given a string input one and two separated by commas When add is called Then the result is 3")
    void whenCalledWtihStringRepresenting2IntsSeperatedByaCommaItShouldReturnTheSum() {
        assertEquals(3, stringAdder.add("1,2"));
    }

    @Test
    @DisplayName("Given a string input one ended by a commas When add is called Then the result is 1")
    void whenCalledWtihStringRepresentingOneIntEndedByaCommaItShouldReturnThisInt() {
        assertEquals(1, stringAdder.add("1,"));
    }

    @Test
    @DisplayName("Given a string input comma followed by one When add is called Then the result is 1")
    void whenCalledWtihStringRepresentingACommaFollowedByIntThenItShouldReturnThisInt() {
        assertEquals(1, stringAdder.add(",1"));
    }

    @Test
    @DisplayName("Given a string input one to four separated by commas  When add is called Then the result is 1")
    void whenCalledWtihStringRepresenting1To4SeparatedByCommaThenItShouldReturnTheSum() {
        assertEquals(10, stringAdder.add("1,2,3,4"));
    }
}


