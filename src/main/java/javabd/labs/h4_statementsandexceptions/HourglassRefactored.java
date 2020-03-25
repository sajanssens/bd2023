package javabd.labs.h4_statementsandexceptions;

public class HourglassRefactored {
    public static void main(String[] args) {
        int n = 9;
        printHourglass(n);
    }

    private static void printHourglass(int n) {
        if (n % 2 == 0) throw new EvenNumberException("Even numbers not allowed");
        buildFullLine(n);

        for (int i = 1; i <= n / 2 - 1; i++) {
            buildRow(n, i);
        }

        buildCenter(n);

        for (int i = n / 2 - 1; i >= 1; i--) {
            buildRow(n, i);
        }

        buildFullLine(n);
    }

    private static void buildFullLine(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    private static void buildRow(int n, int i) {
        printSpaces(i);
        System.out.print("*");
        printSpaces(n - 2 * i - 2);
        System.out.print("*");
        printSpaces(i);

        System.out.println();
    }

    private static void buildCenter(int n) {
        printSpaces(n / 2);
        System.out.print("*");
        System.out.println();
    }

    private static void printSpaces(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print(" ");
        }
    }
}
