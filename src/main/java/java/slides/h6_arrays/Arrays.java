package java.slides.h6_arrays;

import java.util.Random;

public class Arrays {

    public static void main(String[] args) {
        long[] row = new long[4];
        long[] copy = row;
        row[0]++;
        System.out.println(copy[0]);


        int[] intArr = createArray(10, 50);

        double[] accountBalance = {10000, 20000, 5000};
        addInterest(accountBalance);
    }

    public static int[] createArray(int length, int upperBound) {
        Random random = new Random();
        int[] tempArr = new int[length];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = random.nextInt(upperBound) + 1;
        }
        return tempArr;
    }

    public static void addInterest(double[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] *= 1.04;
        }
    }


}
