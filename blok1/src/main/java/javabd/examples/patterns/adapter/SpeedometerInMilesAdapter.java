package javabd.examples.patterns.adapter;

public class SpeedometerInMilesAdapter implements Speedometer  {
    private SpeedometerMiles speedometerMiles;

    public SpeedometerInMilesAdapter(SpeedometerMiles speedometerMiles) {
        this.speedometerMiles = speedometerMiles;
    }

    public double retrieveMaxSpeedInKmh() {
        return speedometerMiles.retrieveMaxSpeedInMh() * 1.6;
    }
}
