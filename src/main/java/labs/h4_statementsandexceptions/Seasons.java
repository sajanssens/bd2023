package labs.h4_statementsandexceptions;

public class Seasons {

    public static void main(String[] args) {
        Season s = Season.DRY;
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

enum Season {
    SPRING, SUMMER, FALL, WINTER, DRY, WET;
}