package javabd.labs.h5_methods;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FiboBigDecimal {

    private BigDecimal run(int f1, int f2, int n) {
        BigDecimal fOne = new BigDecimal(f1);
        BigDecimal fTwo = new BigDecimal(f2);
        BigDecimal sum = fOne.add(fTwo);

        for (int i = 0; i < n - 2; i++) {
            fOne = fTwo;
            fTwo = sum;
            sum = fOne.add(fTwo);
        }

        return sum.subtract(fOne);
    }

    public BigDecimal goldenRatio(int n) {
        BigDecimal runN = run(1, 1, n);
        BigDecimal runN_1 = run(1, 1, n - 1);
        return runN.divide(runN_1, 10, RoundingMode.HALF_UP);
    }

}
