package LLDofVehicleRentalSystem.Payment;

import LLDofVehicleRentalSystem.Bill.Bill;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class PaymentManager {
    private PaymentStrategy paymentStrategy;
    private final Map<Integer, Payment> payments;

    public PaymentManager(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        this.payments = new ConcurrentHashMap<>();
    }

    public Payment makePayment(Bill bill, double paymentAmount) {
        Payment payment = paymentStrategy.processPayment(bill, paymentAmount);
        payments.put(payment.getPaymentId(), payment);
        return payment;
    }

    public List<Payment> getPaymentsForBill(int billId) {
        return payments.values().stream().filter(p -> p.getBillId() == billId).collect(Collectors.toList());
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Optional<Payment> getPayment(int paymentId) {
        return Optional.ofNullable(payments.get(paymentId));
    }
}
