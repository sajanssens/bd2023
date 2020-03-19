package labs.h6_arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ArraysLab {
    public static void main(String[] args) {
        // readNumbers();
        // System.out.println("-------------");
        // sudoku();
        // System.out.println("-------------");
        sudokuAlternative();
    }

    private static void readNumbers() {
        final int SIZE = 3;

        Scanner s = new Scanner(System.in);
        int[] numbers = new int[SIZE];

        System.out.printf("Enter %d numbers...", SIZE);
        for (int i = 0; i < SIZE; i++) {
            // String number = s.nextLine();
            // numbers[i] = Integer.parseInt(number);
            int number = s.nextInt();
            numbers[i] = number;
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum=" + sum);
    }

    private static void sudoku() {
        final int SIZE = 3;
        int[][] randoms = new int[SIZE][SIZE];
        Random r = new Random();
        for (int j = 0; j < SIZE; j++) {
            for (int k = 0; k < SIZE; k++) {
                int poging = r.nextInt(SIZE * SIZE + 1);
                while (contains(randoms, poging)) {
                    poging = r.nextInt(SIZE * SIZE + 1);
                }
                randoms[j][k] = poging;
                System.out.print(randoms[j][k]);
            }
            System.out.println();
        }
    }

    private static void sudokuAlternative() {
        final int SIZE = 3;

        Integer[] ints = new Integer[SIZE * SIZE];
        for (int j = 1; j <= SIZE * SIZE; j++) {
            ints[j - 1] = j;
        }
        Collections.shuffle(Arrays.asList(ints));

        int[][] randoms = new int[SIZE][SIZE];
        for (int j = 0; j < SIZE; j++) {
            for (int k = 0; k < SIZE; k++) {
                randoms[j][k] = ints[j * SIZE + k];
                System.out.print(randoms[j][k]);
            }
            System.out.println();
        }
    }

    private static boolean contains(int[][] randoms, int attempt) {
        for (int j = 0; j < randoms.length; j++) {
            for (int k = 0; k < randoms[j].length; k++) {
                if (randoms[j][k] == attempt) return true;
            }
        }
        return false;
    }
}
