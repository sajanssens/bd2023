package unittesting.labs.lab1.stringadder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringAdderRefactoredTest {

    private static final String EMPTY_STRING = "";
    private StringAdderRefactored stringAdder;

    @BeforeEach
    public void setUp() {
        stringAdder = new StringAdderRefactored();
    }

    @Test
    void whenAddEmptyStringItShouldReturnZero() {
        assertEquals(0, stringAdder.add(EMPTY_STRING));
    }

    @Test
    void whenAddStringOneItShouldReturnIntOne() {
        assertEquals(1, stringAdder.add("1"));
    }

    @Test
    void whenAdd2IntsSeperatedByCommaItShouldReturnTheSum() {
        assertEquals(3, stringAdder.add("1,2"));
    }

    @Test
    void whenAddOneIntEndedByCommaItShouldReturnThisInt() {
        assertEquals(1, stringAdder.add("1,"));
    }

    @Test
    void whenAddCommaFollowedByIntThenItShouldReturnThisInt() {
        assertEquals(1, stringAdder.add(",1"));
    }

    @Test
    void whenAddSeparatedByCommaThenItShouldReturnTheSum() {
        assertEquals(10, stringAdder.add("1,2,3,4"));
    }

}