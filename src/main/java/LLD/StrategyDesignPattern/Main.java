package LLD.StrategyDesignPattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double amount = 100;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available payment methods:");
        System.out.println("1. GPay");
        System.out.println("2. PayPal");
        System.out.println("3. Card");
        System.out.println("Enter the serial number of your preferred payment method: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        PaymentProcessor processor = null;

        switch (choice) {
            case 1:
                System.out.println("Enter your GPay pin: ");
                int pin = scanner.nextInt();
                processor = new GPayPaymentProcessor(pin);
                break;
            case 2:
                System.out.println("Enter your email linked to PayPal: ");
                String email = scanner.nextLine();
                processor = new PayPalPaymentProcessor(email);
                break;
            case 3:
                System.out.println("Enter the card number: ");
                String cardNumber = scanner.nextLine();
                System.out.println("Enter the CVV: ");
                String cvv = scanner.nextLine();
                System.out.println("Enter the expiry date: ");
                String expDate = scanner.nextLine();
                System.out.println("Enter the card holder name: ");
                String name = scanner.nextLine();
                processor = new CardPaymentProcessor(name, cvv, cardNumber, expDate);
                break;
            default:
                throw new RuntimeException("Invalid payment processor selected");
        }

        PaymentService service = new PaymentService(processor);
        service.processPayment(amount);
        scanner.close();
    }
}
