package javabd.labs.h10_inheritance.micro;

public class GoldCard extends Card {

    private int discount;

    public GoldCard(int cardId, String name, double credit, int discount) {
        this(cardId, name, credit, "", "", discount);
    }

    public GoldCard(int cardId, String name, double credit, String address, String city, int discount) {
        super(cardId, name, credit, address, city);
        setDiscount(discount);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        if((discount > 0) && (discount <= 30)) {
            this.discount = discount;
        } else {
            throw new ArgumentOutOfRangeException("Invalid discount has been assigned!");
        }
    }

    @Override
    public String toString() {
        return String.format("%1$-8d %2$-8s %3$-9.2f %4$d", getCardId(), getName(), getCredit(), getDiscount());
    }

    double getDiscountPercentage() {
        return (100.0D - getDiscount()) / 100.0D;
    }

    @Override
    public boolean pay(int amount) {
        setCredit(getCredit() - (amount * getDiscountPercentage()));
        return (getCredit() >= (amount * getDiscountPercentage()));
    }
}
