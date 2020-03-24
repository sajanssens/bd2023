package unittesting.lab1.stringadder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringAdderTest {
    StringAdder stringAdder;
    private static final String EMPTY_STRING = "";

    @BeforeEach
    public void setUp() {
        stringAdder = new StringAdder();
    }

    @Test
    void whenAddIsCalledWithEmptyStringItShouldReturnZero() {
        assertEquals(0, stringAdder.add(EMPTY_STRING));
    }

    @Test
    void whenAddIsCalledWithStringOneItShouldReturnIntOne() {
        assertEquals(1, stringAdder.add("1"));
    }

    @Test
    void whenCalledWithStringRepresenting2IntsSeperatedByaCommaItShouldReturnTheSum() {
        assertEquals(3, stringAdder.add("1,2"));
    }

    @Test
    void whenCalledWithStringRepresentingOneIntEndedByaCommaItShouldReturnThisInt() {
        assertEquals(1, stringAdder.add("1,"));
    }

    @Test
    void whenCalledWithStringRepresentingACommaFollowedByIntThenItShouldReturnThisInt() {
        assertEquals(1, stringAdder.add(",1"));
    }

    @Test
    void whenCalledWithStringRepresenting1To4SeparatedByCommaThenItShouldReturnTheSum() {
        assertEquals(10, stringAdder.add("1,2,3,4"));
    }
}


