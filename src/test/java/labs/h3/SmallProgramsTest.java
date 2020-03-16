package labs.h3;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallProgramsTest {

    @Test
    void whenKlokIsCalledThenResultIsCorrect() {
        // given
        SmallPrograms sp = new SmallPrograms();

        // when
        int resultaat1 = sp.klok(23, 5);
        int resultaat2 = sp.klok(12, 7);

        // then
        assertEquals(4, resultaat1);
        assertEquals(19, resultaat2);
    }

    @Test
    void givenSomeNumberOfMinutes_WhenIAskHowManyHoursAndMinutesAreContained_ThenAnswerIsCorrect() {
        // given
        SmallPrograms sp = new SmallPrograms();
        int numberOfMinutes0 = 0;
        int numberOfMinutes = 576;
        int numberOfMinutesNeg = -345;
        int numberOfMinutesLow = 35;

        // when
        Point hoursAndMinutes0 = sp.howManyHoursAndMinutes(numberOfMinutes0);
        Point hoursAndMinutes = sp.howManyHoursAndMinutes(numberOfMinutes);
        Point hoursAndMinutesNeg = sp.howManyHoursAndMinutes(numberOfMinutesNeg);
        Point hoursAndMinutesLow = sp.howManyHoursAndMinutes(numberOfMinutesLow);

        // then
        assertEquals(0, hoursAndMinutes0.x);
        assertEquals(0, hoursAndMinutes0.y);

        assertEquals(9, hoursAndMinutes.x);
        assertEquals(36, hoursAndMinutes.y);

        assertEquals(-5, hoursAndMinutesNeg.x);
        assertEquals(-45, hoursAndMinutesNeg.y);

        assertEquals(0, hoursAndMinutesLow.x);
        assertEquals(35, hoursAndMinutesLow.y);
    }
}