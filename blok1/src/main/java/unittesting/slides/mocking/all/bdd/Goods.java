package unittesting.slides.mocking.all.bdd;

import java.util.ArrayList;
import java.util.List;

public class Goods {
    private List<Good> contents = new ArrayList<>();

    public Goods(Bread bread) {contents.add(bread);}

    public Good get(int i) {return contents.get(i);}

}
