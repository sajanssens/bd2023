package unittesting.slides.mocking.all.bdd;

public class Shop {
    private final Seller seller;

    public Shop(Seller seller) {this.seller = seller;}

    public Goods buyBread() { return seller.askForBread(); }
}
