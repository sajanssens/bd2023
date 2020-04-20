package javabd.examples.patterns.adapter;

public class DutchSpeedometer implements Speedometer {
    @Override
    public double retrieveMaxSpeedInKmh() {
        return 200;
    }
}
