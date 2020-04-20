package javabd.labs.h6_arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HomeworkTest {

    private Homework hw = new Homework();

    @Test
    void longsTest() {
        long[] longs = hw.longs();
        assertThat(longs[2], is(4L));
    }

    @Test
    void testCopy() {
        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;
        assertThat(copy[2], is(4L));
    }

    @Test
    void testExtend() {
        long[] row = {1L, 2L, 3L, 4L};
        long[] extend = hw.extend(row);

        assertThat(extend.length, is(row.length * 2));
        assertThat(extend[2], is(3L));
        assertThat(row[2], is(3L));
        assertThat(extend[5], is(0L));
    }

    @Test
    void testMultiply() {
        int multiplier = 2;
        long[] row = {1L, 2L, 3L, 4L};
        long[] row2 = {1L, 2L, 3L, 4L};

        hw.multiply(row2, multiplier);

        for (int i = 0; i < row2.length; i++) {
            assertThat(row2[i], is(row[i] * multiplier));
        }
    }

    @Test
    void testRun() {
        int n = 10;
        long[] seq = hw.run(n);
        assertThat(seq.length, is(n));

        for (long f : seq) {
            System.out.print(f + " ");
        }
    }
}