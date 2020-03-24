package unittesting.lab1.stringadder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("StringAdder add(String numbers) tests")
class StringAdderWithDisplayAndNestingTests {
	StringAdder stringAdder;
	private static final String EMPTY_STRING = "";

	@BeforeEach
	public void setUp() {
		stringAdder = new StringAdder();
	}
	@Nested
	@DisplayName("Given string input represents empty string")
	class StringInputEmpty {
		final float input2 = 2;

		@DisplayName("Given as input an empty string When add is called Then the result is 0")
		@Test
		void whenAddIsCalledWithEmptyStringItShouldReturnZero() {
			assertEquals(0, stringAdder.add(EMPTY_STRING));
		}

	}
	@Nested
	@DisplayName("Given string input representing one number")
	class StringInputOneNumber {
		final float input2 = 2;

		@DisplayName("Given string represents one When add is called Then the result is 1")
		@Test
		void whenAddIsCalledWithStringOneItShouldReturnIntOne() {
			assertEquals(1, stringAdder.add("1"));
		}

	}
	
	@Nested
	@DisplayName("Given string input representing optionally 2 numbers separated by a comma")
	class StringInputRepresentingOptionallyTwoNumbers {
		@DisplayName("Given one and two separated by commas When add is called Then the result is 3")
		@Test
		void whenCalledWtihStringRepresenting2IntsSeperatedByaCommaItShouldReturnTheSum() {
			assertEquals(3, stringAdder.add("1,2"));
		}

		@DisplayName("Given a string input one eand a commas When add is called Then the result is 1")
		@Test
		void whenCalledWtihStringRepresentingOneIntEndedByaCommaItShouldReturnThisInt() {
			assertEquals(1, stringAdder.add("1,"));
		}

		@DisplayName("Given a comma followed by one When add is called Then the result is 1")
		@Test
		void whenCalledWtihStringRepresentingACommaFollowedByIntThenItShouldReturnThisInt() {
			assertEquals(1, stringAdder.add(",1"));
		}
	}
	
}

