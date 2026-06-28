package LLD.AdapterDesignPattern;

import java.util.Scanner;

public class PaymentFactory {

    public static PaymentProcessor createPaymentProcessor(int processorChoice) {
        Scanner scanner = new Scanner(System.in);
        PaymentProcessor processor = null;
        switch (processorChoice) {
            case 1:
                System.out.println("Enter the phone number linked with the RazorPay account: ");
                String phoneNumber = scanner.nextLine();
                processor = new RazorPayAdapter(phoneNumber);
                break;
            case 2:
                System.out.println("Enter the card number linked to the Stripe account: ");
                String cardNumber = scanner.nextLine();
                processor = new StripeAdapter(cardNumber);
                break;
            case 3:
                throw new RuntimeException("Invalid choice of payment processor");
        }
        scanner.close();
        return processor;
    }
}
