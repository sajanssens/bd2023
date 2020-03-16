package labs.h5_methods;

public class Fibo {

    public int run(int n) {
        return run(1, n);
    }

    public int run(int start, int n) {
        return run(start, start, n);
    }

    public int run(int f1, int f2, int n) {
        int fOne = f1;
        int fTwo = f2;
        int sum = fOne + fTwo;

        System.out.print(fOne + " ");
        System.out.print(fTwo + " ");

        for (int i = 0; i < n - 2; i++) {
            System.out.print(sum + " ");
            fOne = fTwo;
            fTwo = sum;
            sum = fOne + fTwo;
        }
        return fTwo;
    }

    public float goldenRatio(int n) {
        return (float) run(n) / run(n - 1);
    }

}
