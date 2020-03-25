package javabd.labs.h5_methods;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class FiboTest {

    private Fibo fib = new Fibo();

    @Test
    void testRun1() {
        long run = fib.run(6);
        assertThat(run, is(8L));
    }

    @Test
    void testRun2() {
        long run = fib.run(4, 6);
        assertThat(run, is(32L));
    }

    @Test
    void testRun3() {
        long run = fib.run(4, 5, 6);
        assertThat(run, is(37L));
    }

    @Test
    void testGoldenRatio10() {
        float gr = fib.goldenRatio(10);
        assertThat(gr, is(1.617647f));
        System.out.println();
        gr = fib.goldenRatio(96);
        System.out.println();
        System.out.println(gr);
    }

    @Test
    void testGoldenRatio() {
        int n = 0;
        float gr = fib.goldenRatio(n);
        while (gr >= 1.0f && gr <= 2.0f) {
            n++;
            gr = fib.goldenRatio(n);
        }

        assertThat(n, greaterThan(0));
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

    @Test
    void testFiboRec() {
        int run = fib.printFiboRec(6);
        assertThat(run, is(8));
    }
}