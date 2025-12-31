package LLDofVehicleRentalSystem.Bill;

import LLDofVehicleRentalSystem.Reservation.Reservation;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class BillManager {
    private BillingStrategy billingStrategy;
    private final Map<Integer, Bill> bills;

    public BillManager(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
        this.bills = new ConcurrentHashMap<>();
    }

    public Bill generateBill(Reservation reservation) {
        Bill bill = billingStrategy.generateBill(reservation);
        bills.put(bill.getBillId(), bill);
        return bill;
    }

    public Optional<Bill> getBill(int billId) {
        return Optional.ofNullable(bills.get(billId));
    }

    public void setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }
}
