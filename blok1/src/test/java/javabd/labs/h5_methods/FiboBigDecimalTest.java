package javabd.labs.h5_methods;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class FiboBigDecimalTest {
    private static final int LIMIT = 1000;
    private FiboBigDecimal fib = new FiboBigDecimal();

    @Test
    void testGoldenRatioNoLimit() {
        int n = 0;
        BigDecimal gr = fib.goldenRatio(n);
        while (gr.floatValue() >= 1.0f && gr.floatValue() <= 2.0f && n < LIMIT) {
            n++;
            gr = fib.goldenRatio(n);
        }

        // n could be anything now
        assertThat(n, is(LIMIT));

        // golden ratio should still be between 1.6 and 1.7 for any n
        gr = fib.goldenRatio(n);
        assertThat(gr.floatValue(), allOf(greaterThan(1.6f), lessThan(1.7f)));
        System.out.println(gr);
    }
}