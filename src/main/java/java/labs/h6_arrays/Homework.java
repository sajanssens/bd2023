package java.labs.h6_arrays;

public class Homework {


    public long[] longs(){
        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;

        return copy;
    }

    public long[] extend(long[] input) {
        long[] copy = new long[input.length * 2];
        for (int i = 0; i < input.length; i++) {
            copy[i] = input[i];
        }

        return copy;
    }

    public void multiply(long[] input, int multiplier) {
        for (int i = 0; i < input.length; i++) {
            input[i] *= multiplier;
        }
    }

    public long[] run(int n) {
        long[] sequence = new long[n];
        long fOne = 1;
        long fTwo = 1;
        long sum = fOne + fTwo;

        sequence[0] = fOne;
        sequence[1] = fTwo;

        for (int i = 2; i < n; i++) {
            sequence[i] = sum;
            fOne = fTwo;
            fTwo = sum;
            sum = fOne + fTwo;
        }
        return sequence;
    }

}
