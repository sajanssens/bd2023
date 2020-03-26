package unittesting.labs.lab2.mocking.lab;

public class TrajectPrijsService {

    private TrajectNaarTrajectEenhedenService trajectNaarTrajectEenhedenService;
    private TrajectEenhedenNaarPrijsService trajectEenhedenNaarPrijsService;

    public int getTrajectPrijs(String from, String to) {
        int eenheden = trajectNaarTrajectEenhedenService.getTrajectEenheden(from, to);
        int price = trajectEenhedenNaarPrijsService.getPriceTrajectEenheden(eenheden);
        return eenheden * price;

    }

    public void setTrajectNaarTrajectEenhedenService(TrajectNaarTrajectEenhedenService s) {
        this.trajectNaarTrajectEenhedenService = s;
    }

    public void setTrajectEenhedenNaarPrijsService(TrajectEenhedenNaarPrijsService s) {
        this.trajectEenhedenNaarPrijsService = s;
    }
}
