package java.labs.h4_statementsandexceptions;

import java.util.Scanner;

public class ElevenProof {

    public ElevenProof() {

    }

    public void run() {
        String number = leesInput();

        checkLength(number);

        int sum = sum(number);
        System.out.println(sum);
        validate(sum);
    }

    private String leesInput() {
        System.out.println("Enter your accountnumber: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    void checkLength(String number) {
        if (number.length() == 9) {
            throw new IllegalArgumentException("Account number length should be 9.");
        }
    }

    int sum(String number) {
        int sum = 0;
        try {
            for (int i = 1; i <= number.length(); i++) {
                String digit = number.charAt(i - 1) + "";
                // System.out.println(digit);
                sum += Integer.parseInt(digit) * (number.length() + 1 - i);
            }
        } catch (NumberFormatException e) {
            System.out.println("Geef een geldig nummer in!");
            System.err.println("No valid number. Message is: " + e.getMessage());
        }

        return sum;
    }

    private void validate(int sum) {
        if (sum % 11 == 0) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
            throw new IllegalArgumentException("Invalid account number");
        }
    }
}
