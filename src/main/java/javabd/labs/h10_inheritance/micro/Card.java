package javabd.labs.h10_inheritance.micro;

public abstract class Card {
    private int cardId;
    private String name;
    private double credit;
    private String address;
    private String city;

    public Card(int cardId, String name, double credit) {
        this(cardId, name, credit, "", "");
    }

    public Card(int cardId, String name, double credit, String address, String city) {
        this.cardId = cardId;
        this.name = name;
        this.credit = credit;
        this.address = address;
        this.city = city;
    }

    public int getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public abstract boolean pay(int amount);
}
