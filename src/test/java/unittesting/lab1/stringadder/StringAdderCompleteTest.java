package unittesting.lab1.stringadder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAdderCompleteTest {

    private static final String EMPTY_STRING = "";
    private StringAdderComplete stringAdder;

    @BeforeEach
    public void setUp() {
        stringAdder = new StringAdderComplete();
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
    void whenAdd2IntsSeparatedByCommaItShouldReturnTheSum() {
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

    @Test
    void whenAddSeparatedByNewLineThenItShouldReturnTheSum() {
        assertEquals(6, stringAdder.add("1\n2,3"));
        assertEquals(10, stringAdder.add("1\n2,3\n4"));
    }

    @Test
    void whenAddEndsWithNewLineThenItShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> stringAdder.add("1\n"));
    }

    @Test
    void whenAddWithAnotherDelimiterThenItShouldReturnTheSum() {
        assertEquals(3, stringAdder.add("//;\n1;2"));
    }

    @Test
    void whenAddWithDelimiterMinusThenItShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> stringAdder.add("//-\n1;2"));
    }

    @Test
    void whenAddWithNegativeNumbersThenItShouldThrowIllegalArgumentException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> stringAdder.add("1,-2,-3,4"));

        String message = e.getMessage();
        assertTrue(message.contains("-2"));
        assertTrue(message.contains("-3"));
    }

    @Test
    void whenAddWithNumbersLargerThan1000ItShouldIgnoreThoseLargeNumbers() {
        assertEquals(2, stringAdder.add("2,1001"));
    }

}