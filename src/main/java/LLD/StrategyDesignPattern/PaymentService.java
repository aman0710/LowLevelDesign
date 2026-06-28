package LLD.StrategyDesignPattern;

public class PaymentService {
    private PaymentProcessor processor;

    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void setProcessor(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void processPayment(double amount) {
        processor.processPayment(amount);
    }
}
