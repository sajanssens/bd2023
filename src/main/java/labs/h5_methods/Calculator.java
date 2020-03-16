package labs.h5_methods;

import static labs.h5_methods.TailCalls.call;
import static labs.h5_methods.TailCalls.done;

public class Calculator {

    public int greatest(int i, int j) {
        if (i >= j) {
            return i;
        } else {
            return j;
        }
    }

    public String greatest(String s1, String s2) {
        if (s1.length() >= s2.length()) {
            return s1;
        } else {
            return s2;
        }
    }

    public int greatest(int... ints) {
        int max = ints[0];
        for (int i : ints) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public int factorial(int n) {
        if (n <= 1) return n;

        return n * factorial(n - 1);
    }

    public int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    // Not in homework, but interesting anyway:
    public int factorialTail(int n) {
        return factorialTail(1, n);
    }

    public int factorialTailLazy(int n) {
        return factorialTailLazy(1, n).invoke();
    }

    private int factorialTail(int intermediaryResult, int n) {
        if (n <= 1) return intermediaryResult; // for n=1 we've reached the endresult
        return factorialTail(intermediaryResult * n, n - 1); // next value is intermediary result times n, i.e. 5! = 5*4, then that *3, that*2, that*1
    }

    private TailCall<Integer> factorialTailLazy(int intermediaryResult, int n) {
        if (n <= 1) return done(intermediaryResult); // execute
        return call(() -> factorialTailLazy(intermediaryResult * n, n - 1)); // suspend execution
    }

    public int fibTail(int n) {
        return fibTail(n, 1, 0);
    }

    public int fibTailLazy(int n) {
        return fibTailLazy(n, 1, 0).invoke();
    }

    private int fibTail(int n, int curr, int prev) {
        if (n == 0) return prev;
        return fibTail(n - 1, curr + prev, curr);
    }

    private TailCall<Integer> fibTailLazy(int n, int curr, int prev) {
        if (n == 0) return done(prev);
        return call(() -> fibTailLazy(n - 1, curr + prev, curr));
    }

    public long facIterative(int n) {
        long result = 1;
        for (int i = n; i > 0; i--) {
            result = result * i;
        }
        return result;
    }
}
