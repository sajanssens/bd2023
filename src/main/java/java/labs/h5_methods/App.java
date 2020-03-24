package java.labs.h5_methods;

public class App {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int max = calc.greatest(3, 2);
        System.out.println(max);

        String longest = calc.greatest("Jan", "Piet");
        System.out.println(longest);

        max = calc.greatest(3, 20, 5, 6);
        System.out.println(max);

        int factorial = calc.factorial(5);
        System.out.println(factorial);

        long factorialIt = calc.facIterative(5);
        System.out.println(factorialIt);
    }
}
