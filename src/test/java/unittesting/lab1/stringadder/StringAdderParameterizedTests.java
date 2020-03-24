package unittesting.lab1.stringadder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@DisplayName("StringAdder add(String numbers) tests")
class StringAdderParameterizedTests {
    private StringAdder stringAdder;

    @BeforeEach void setUp() {
        stringAdder = new StringAdder();
    }

    @TestFactory
    @DisplayName("Given string input representing optionally 2 numbers separated by a comma")
    public Collection<DynamicTest> oneAndTwo() {
        Set<DynamicTest> tests = new LinkedHashSet<>();

        tests.add(createTest("", 0));
        tests.add(createTest("1", 1));
        tests.add(createTest("1,", 1));
        tests.add(createTest("2", 2));
        tests.add(createTest(",2", 2));
        tests.add(createTest("1,2", 3));
        tests.add(createTest(",1,2", 3));

        return tests;
    }

    private DynamicTest createTest(String input, int exp) {
        String displayName = format("Given a string input \"%s\" When add is called Then the result is %d.", input, exp);
        return dynamicTest(displayName, () -> assertEquals(exp, stringAdder.add(input)));
    }
}
