package labs.h5_methods;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class FiboLongTest {

    private FiboLong fib = new FiboLong();

    @Test
    void testGoldenRatio() {
        int n = 0;
        float gr = fib.goldenRatio(n);
        while (gr >= 1.0f && gr <= 2.0f) {
            n++;
            gr = fib.goldenRatio(n);
        }

        assertThat(n, greaterThan(46));
        System.out.println();
        System.out.println(n);

        // golden ratio should be between 1.6 and 1.7 for n-1
        gr = fib.goldenRatio(n - 1);
        assertThat(gr, allOf(greaterThan(1.6f), lessThan(1.7f)));

        // golden ratio should not be between 1.6 and 1.7 for n,
        // so less than 1.6 or greater than 1.7
        gr = fib.goldenRatio(n);
        assertThat(gr, anyOf(lessThan(1.6f), greaterThan(1.7f)));
    }
}