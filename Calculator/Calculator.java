import java.util.Scanner;

public class Calculator {

    // Basic operations
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero");
            return 0;
        }
        return a / b;
    }

    // Scientific operations
    public static double squareRoot(double a) {
        return Math.sqrt(a);
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Unit conversion
    public static double celsiusToFahrenheit(double c) {
        return (c * 9/5) + 32;
    }

    public static double inrToUsd(double inr) {
        return inr / 83.0; // approx conversion
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Calculator Menu ===");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Square Root");
            System.out.println("6. Power");
            System.out.println("7. Celsius to Fahrenheit");
            System.out.println("8. INR to USD");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            double a, b;

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    System.out.println("Result: " + add(a, b));
                    break;

                case 2:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    System.out.println("Result: " + subtract(a, b));
                    break;

                case 3:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    System.out.println("Result: " + multiply(a, b));
                    break;

                case 4:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    System.out.println("Result: " + divide(a, b));
                    break;

                case 5:
                    System.out.print("Enter number: ");
                    a = sc.nextDouble();
                    System.out.println("Result: " + squareRoot(a));
                    break;

                case 6:
                    System.out.print("Enter base and exponent: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    System.out.println("Result: " + power(a, b));
                    break;

                case 7:
                    System.out.print("Enter Celsius: ");
                    a = sc.nextDouble();
                    System.out.println("Fahrenheit: " + celsiusToFahrenheit(a));
                    break;

                case 8:
                    System.out.print("Enter INR: ");
                    a = sc.nextDouble();
                    System.out.println("USD: " + inrToUsd(a));
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 9);

        sc.close();
    }
}
