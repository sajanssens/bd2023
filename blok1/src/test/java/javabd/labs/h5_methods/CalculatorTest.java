package javabd.labs.h5_methods;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    void greatest() {
        int max = calc.greatest(3, 2);
        assertThat(max, is(3));
    }

    @Test
    void testGreatest() {
        String longest = calc.greatest("Jan", "Piet");
        assertThat(longest, is("Piet"));
    }

    @Test
    void testGreatest1() {
        int max = calc.greatest(3, 20, 5, 6);
        assertThat(max, is(20));
    }

    @Test
    void factorial() {
        int factorial = calc.factorial(5);
        assertThat(factorial, is(120));
    }

    @Test
    void factorialStackOverflow() {
        assertThrows(StackOverflowError.class, () -> calc.factorial(20_000));
    }

    @Test
    void factorialTailStackOverflow() {
        assertThrows(StackOverflowError.class, () -> calc.factorialTail(20_000));
    }

    @Test
    void factorialTailLazy() {
        int factorial = calc.factorialTailLazy(5);
        assertThat(factorial, is(120));
    }

    @Test
    void factorialTailLazyNoStackOverflow() {
        int factorial = calc.factorialTailLazy(20_000);
        assertThat(factorial, is(0)); // 0, because result is too large, but hey, no stackoverflowerror!
    }

    @Test
    void fib() {
        int fib = calc.fib(11);
        assertThat(fib, is(89));

        // slow!
        // for (int i = 0; i < 45; i++) { System.out.println(calc.fib(i)); }
    }

    @Test
    void fibTail() {
        int fib = calc.fibTail(11);
        assertThat(fib, is(89));

        // fast
        // for (int i = 0; i < 45; i++) { System.out.println(calc.fibTail(i)); }
    }

    @Test
    void fibTailLazy() {
        int fib = calc.fibTailLazy(11);
        assertThat(fib, is(89));

        // fast (bit slower than fibTail though, but no stackoverflow)
        // for (int i = 0; i < 45; i++) { System.out.println(calc.fibTailLazy(i)); }
    }

}