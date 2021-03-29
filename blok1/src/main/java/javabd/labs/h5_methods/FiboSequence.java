package javabd.labs.h5_methods;

public class FiboSequence {

    int a;
    int b;

    public FiboSequence(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int yield() {
        int sum = a + b;
        a = b;
        b = sum;

        return sum;
    }

    public static int fibo(int n) {
        int sum = 0;
        FiboSequence fiboSequence = new FiboSequence(0, 1);
        for (int i = 0; i < n; i++) { sum = fiboSequence.yield(); }
        return sum;
    }

}
