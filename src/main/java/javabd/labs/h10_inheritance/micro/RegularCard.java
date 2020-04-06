package javabd.labs.h10_inheritance.micro;

public class RegularCard extends Card {

    public RegularCard(int cardId, String name, double credit) {
        this(cardId, name, credit, "", "");
    }

    public RegularCard(int cardId, String name, double credit, String address, String city) {
        super(cardId, name, credit, address, city);
    }

    @Override
    public String toString() {
        return String.format("%1$-8d %2$-8s %3$.2f", getCardId(), getName(), getCredit());
    }

    @Override
    public boolean pay(int amount) {
        boolean canPay;
        if (getCredit() >= amount) {
            canPay = true;
            setCredit(getCredit() - amount);
        } else {
            canPay = false;
        }
        return canPay;
    }
}