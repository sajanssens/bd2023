package javabd.labs.h4_statementsandexceptions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ElevenProofTest {

    private ElevenProof target;

    @Before
    public void initBeforeEeachTestCase() {
        target = new ElevenProof();
    }

    @Test
    public void checkLengthHappyFlow() {
        target.checkLength("123456789");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkLengthTooShort() {
        target.checkLength("1234567");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkLengthTooLong() {
        target.checkLength("1234567891234");
    }

    @Test
    public void sumShouldFailGracefullyWhenInvalidInput() {
        target.sum("ABC");
    }
}