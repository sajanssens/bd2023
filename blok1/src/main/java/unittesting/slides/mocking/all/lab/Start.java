package unittesting.slides.mocking.all.lab;

public class Start {
    public static void main(String[] args) {
        TrajectPrijsService trajectPrijsService = new TrajectPrijsService();

        // non-anonymous class style:
        trajectPrijsService.setTrajectNaarTrajectEenhedenService(new MyEenhedenService());
        trajectPrijsService.setTrajectEenhedenNaarPrijsService(new MyPrijsService());

        // lambda style (java 8):
        // trajectPrijsService.setTrajectEenhedenNaarPrijsService(aantalTrajectEenheden -> aantalTrajectEenheden + 2);

        // anonymous class style (pre java 8)
        // trajectPrijsService.setTrajectNaarTrajectEenhedenService(new TrajectNaarTrajectEenhedenService() {
        //     // anonymous
        //     @Override public int getTrajectEenheden(String location1, String location2) {
        //         if (location1.equals("XX")) throw new InvalidLocationException();
        //         return 10;
        //     }
        // });

        int trajectPrijs = trajectPrijsService.getTrajectPrijs("XX", "UT");

        System.out.println(trajectPrijs);
    }
}
