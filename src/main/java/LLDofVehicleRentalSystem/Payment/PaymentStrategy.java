package LLDofVehicleRentalSystem.Payment;

import LLDofVehicleRentalSystem.Bill.Bill;

public interface PaymentStrategy {
    Payment processPayment(Bill bill, double amountPaid);
}
