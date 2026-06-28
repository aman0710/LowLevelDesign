package LLD.StrategyDesignPattern;

public class PayPalPaymentProcessor implements PaymentProcessor{
    private String email;

    public PayPalPaymentProcessor(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " through PayPal account linked with email: " + email);
    }
}
