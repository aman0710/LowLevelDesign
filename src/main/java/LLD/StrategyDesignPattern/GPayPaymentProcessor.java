package LLD.StrategyDesignPattern;

public class GPayPaymentProcessor implements PaymentProcessor{

    private int pin;

    public GPayPaymentProcessor(int pin) {
        this.pin = pin;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " via GPay UPI");
    }
}
