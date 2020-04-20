package javabd.examples.patterns.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdapterTest {

    @Test
    public void testAdapter() {
        Speedometer speedometer = new DutchSpeedometer();
        assertEquals(200, speedometer.retrieveMaxSpeedInKmh());

        speedometer = new SpeedometerInMilesAdapter(new BritishSpeedometer());
        assertEquals(192, speedometer.retrieveMaxSpeedInKmh());
    }
}
