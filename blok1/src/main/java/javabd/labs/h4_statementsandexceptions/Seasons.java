package javabd.labs.h4_statementsandexceptions;

public class Seasons {

    public static void main(String[] args) {
        checkTemperature(Season.DRY);
        checkTemperature(Season.SPRING);
    }

    private static void checkTemperature(Season s) {
        switch (s) {
            case SPRING:
            case SUMMER:
                System.out.println(s + " is warm!");
                // break;
            case FALL:
            case WINTER:
                System.out.println(s + " is cold!");
                break;
            default:
                System.out.println(s + " is unknown...");
        }
    }

}



