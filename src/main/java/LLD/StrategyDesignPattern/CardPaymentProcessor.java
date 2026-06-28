package LLD.StrategyDesignPattern;

import ATMLLD.Card;

public class CardPaymentProcessor implements PaymentProcessor{

    private String name;
    private String cvv;
    private String cardNumber;
    private String expDate;

    public CardPaymentProcessor(String name, String cvv, String cardNumber, String expDate) {
        this.name = name;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
    }
    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " via card belonging to: " + name);
    }
}
