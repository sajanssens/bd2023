package javabd.labs.h10_inheritance.micro;

public class Application {
    public static void main(String[] args) {
        RegularCard card1 = new RegularCard(1235, "Gerda", 1000.0D);
        GoldCard card2 = new GoldCard(1236, "Donald", 7000.0D, 10);
        RegularCard card3 = new RegularCard(1237, "Edward", 5000.0D);
        GoldCard card4 = new GoldCard(1238, "Mona", 7000.0D, 10);
        GoldCard card5 = new GoldCard(1239, "Roan", 800.0D, 15);
        RegularCard card6 = new RegularCard(1240, "Vera", 500.0D);

        MicroClientAdministration clientAdministration = new MicroClientAdministration();

        // Add all cards to the client administration
        clientAdministration.addClient(card1);
        clientAdministration.addClient(card2);
        clientAdministration.addClient(card3);
        clientAdministration.addClient(card4);
        clientAdministration.addClient(card5);
        clientAdministration.addClient(card6);

        clientAdministration.printAllClients();
        clientAdministration.performPayment();
        clientAdministration.printAllClients();
    }
}
