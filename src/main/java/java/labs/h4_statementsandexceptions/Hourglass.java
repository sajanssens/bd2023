package java.labs.h4_statementsandexceptions;

public class Hourglass {
    public static void main(String[] args) {
        int n = 9;

        printHourglass(n);
    }

    private static void printHourglass(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int i = 1; i <= n / 2 - 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            System.out.print("*");

            for (int j = 0; j < n - 2 * i - 2; j++) {
                System.out.print(" ");
            }

            System.out.print("*");

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 0; i <= n / 2 - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("*");
        System.out.println();

        for (int i = n / 2 - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            System.out.print("*");

            for (int j = 0; j < n - 2 * i - 2; j++) {
                System.out.print(" ");
            }

            System.out.print("*");

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
