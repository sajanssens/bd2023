package unittesting.matchers.assertj;

import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;
import static unittesting.matchers.assertj.assertions.NotANumberChecker.assertThat;

class NotANumberExampleTest {
    @Test
    void testSquareRootOfMinusOneIsNotANumber() {
        assertThat(sqrt(-1)).isNotANumber();
    }
}
