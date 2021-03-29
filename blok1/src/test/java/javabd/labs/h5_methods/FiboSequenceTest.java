package javabd.labs.h5_methods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FiboSequenceTest {

    private FiboSequence target;

    @BeforeEach
    void setUp() {
        target = new FiboSequence(0, 1);
    }

    @Test
    void next() {
        for (int i = 0; i < 7; i++) {
            System.out.println(target.yield());
        }
    }

    @Test
    void fibo() {
        int fibo = FiboSequence.fibo(7);
        assertThat(fibo).isEqualTo(21);
    }
}
