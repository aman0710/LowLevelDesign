package LLD.AdapterDesignPattern;

public class StripeAdapter implements PaymentProcessor{

    private String cardNumber;
    private final double USD_TO_INR = 96.0;

    public StripeAdapter(String cardNumber) {
        // this.stripeClient = new StripeClient();
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amountInUSD) {
        double amountInRupees = amountInUSD * USD_TO_INR;
        double amountInPaise = amountInRupees * 100;

        // stripeClient.makePayment(cardNumber, amountInPaise);
        System.out.println("Amount of " + amountInPaise + " paise paid using card: " + cardNumber);
    }
}
