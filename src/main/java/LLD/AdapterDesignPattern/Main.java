package LLD.AdapterDesignPattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount to send in USD: ");
        double amountInUSD = scanner.nextDouble();

        System.out.println("Below are the available payment processors: ");
        System.out.println("1. RazorPay");
        System.out.println("2. Stripe");
        System.out.println("Enter the serial number of your preferred payment processor: ");
        int processorChoice = scanner.nextInt();
        PaymentProcessor processor = PaymentFactory.createPaymentProcessor(processorChoice);
        processor.pay(amountInUSD);
    }
}
