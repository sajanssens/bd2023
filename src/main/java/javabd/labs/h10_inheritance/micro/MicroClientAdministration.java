package javabd.labs.h10_inheritance.micro;

import java.util.ArrayList;
import java.util.Scanner;

public class MicroClientAdministration {
    private ArrayList<Card> microClientList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addClient(Card clientToAdd) {
        microClientList.add(clientToAdd);
    }

    public ArrayList<Card> getMicroClientList() {
        return microClientList;
    }

    public Card cardLookup(int cardId) {
        Card foundCard = null;
        for(Card c : microClientList) {
            if(c.getCardId() == cardId) {
                foundCard = c;
            }
        }
        return foundCard;
    }

    public void printAllClients() {
        System.out.printf("%1$-8s %2$-8s %3$-9s %4$s %n", "CardID", "Name", "Credit", "Discount");
        for(Card c : getMicroClientList()) {
            System.out.println(c.toString());
        }
    }

    //TODO Implement ScannerWrapper to enable Mocking
    public boolean performPayment() {
        System.out.println();
        System.out.print("Enter the cardID:  ");
        int cardID = scanner.nextInt();
        Card card = cardLookup(cardID);
        if(card == null) {
            //TODO Implement CardNotFoundException
            System.out.println("Error: Card not found.");
            System.out.println();
            return false;
        }
        scanner.nextLine();
        System.out.print("Enter to amount to pay:  ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return card.pay(amount);
    }

}
