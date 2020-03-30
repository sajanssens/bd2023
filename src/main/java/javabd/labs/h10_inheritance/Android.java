package javabd.labs.h10_inheritance;

public class Android extends Human implements Chargeable {
    private int level;

    @Override
    public String greet() {
        return "I'm only half human, but human still... My enery level is " + level + "%.";
    }

    @Override
    public int charge(int amount) {
        if (level + amount > 100) return level;

        level += amount;
        return level;
    }
}
