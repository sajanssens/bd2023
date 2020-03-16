package labs.h5_methods;

public class FiboLong {

    public long run(int n) {
        return run(1, n);
    }

    public long run(int start, int n) {
        return run(start, start, n);
    }

    public long run(int f1, int f2, int n) {
        long fOne = f1;
        long fTwo = f2;

        System.out.print(fOne + " ");
        System.out.print(fTwo + " ");

        long fibo = f2;
        for (int i = 0; i < n - 2; i++) {
            fibo = fOne + fTwo;
            fOne = fTwo;
            fTwo = fibo;

            System.out.print(fibo + " ");
        }
        return fibo;
    }

    public float goldenRatio(int n) {
        return (float) run(n) / run(n - 1);
    }

}
