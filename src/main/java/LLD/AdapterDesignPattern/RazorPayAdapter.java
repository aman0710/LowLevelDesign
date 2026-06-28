package LLD.AdapterDesignPattern;

public class RazorPayAdapter implements PaymentProcessor {

    String phoneNumber;

    public RazorPayAdapter(String phoneNumber) {
        // this.razorpayClient = new RazorPayClient();
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(double amountInUSD) {
        // razorpayClient.processPayment(phoneNumber, amountInUSD);
        System.out.println("RazorPay paid $" + amountInUSD + " using phone number: " + phoneNumber);
    }
}
