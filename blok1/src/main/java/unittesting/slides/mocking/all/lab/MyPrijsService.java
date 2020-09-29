package unittesting.slides.mocking.all.lab;

public class MyPrijsService implements TrajectEenhedenNaarPrijsService {
    @Override
    public int getPriceTrajectEenheden(int aantalTrajectEenheden) {
        return aantalTrajectEenheden * 2;
    }
}
