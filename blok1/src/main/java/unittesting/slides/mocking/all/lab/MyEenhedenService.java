package unittesting.slides.mocking.all.lab;

import java.util.Random;

public class MyEenhedenService implements TrajectNaarTrajectEenhedenService {
    @Override
    public int getTrajectEenheden(String location1, String location2) {
        return new Random().nextInt(10);
    }
}
