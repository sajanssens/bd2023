package javabd.examples.patterns.adapter;

public class BritishSpeedometer implements SpeedometerMiles {
    @Override
    public double retrieveMaxSpeedInMh() {
        return 120;
    }
}
