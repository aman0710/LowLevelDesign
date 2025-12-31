package LLDofVehicleRentalSystem;

import LLDofVehicleRentalSystem.Bill.Bill;
import LLDofVehicleRentalSystem.Bill.BillManager;
import LLDofVehicleRentalSystem.Bill.BillingStrategy;
import LLDofVehicleRentalSystem.Bill.DailyBillingStrategy;
import LLDofVehicleRentalSystem.Payment.*;
import LLDofVehicleRentalSystem.Reservation.Reservation;
import LLDofVehicleRentalSystem.Reservation.ReservationManager;
import LLDofVehicleRentalSystem.Reservation.ReservationRepository;
import LLDofVehicleRentalSystem.Reservation.ReservationType;
import LLDofVehicleRentalSystem.Vehicle.Vehicle;
import LLDofVehicleRentalSystem.Vehicle.VehicleInventoryManager;
import LLDofVehicleRentalSystem.Vehicle.VehicleType;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Store {
    private final int storeId;
    private final Location storeLocation;
    private final VehicleInventoryManager inventoryManager;
    private final ReservationManager reservationManager;
    private final BillManager billManager;
    private final PaymentManager paymentManager;

    public Store(int storeId, Location storeLocation) {
        this.storeId = storeId;
        this.storeLocation = storeLocation;
        this.inventoryManager = new VehicleInventoryManager();
        this.reservationManager = new ReservationManager(inventoryManager);
        this.billManager = new BillManager(new DailyBillingStrategy(inventoryManager));
        this.paymentManager = new PaymentManager(new UPIPaymentStrategy());
    }

    public List<Vehicle> getVehicles(VehicleType type, LocalDate from, LocalDate to) {
        return inventoryManager.getAvailableVehiclesList(type, from, to);
    }

    public Reservation createReservation(int vehicleId, User user, LocalDate from, LocalDate to, ReservationType type) {
        return reservationManager.createReservation(vehicleId, from, to, user, type);
    }

    public void cancelReservation(int reservationId) {
        reservationManager.cancelReservation(reservationId);
    }

    public void startTrip(int reservationId) {
        reservationManager.startTrip(reservationId);
    }

    public void submitVehicle(int reservationId) {
        reservationManager.submitVehicle(reservationId);
    }

    public Bill generateBill(int reservationId, BillingStrategy billingStrategy) {
        Optional<Reservation> opt = reservationManager.findById(reservationId);
        if(!opt.isPresent()) {
            throw new RuntimeException("Reservation not found!");
        }
        Reservation reservation = opt.get();
        billManager.setBillingStrategy(billingStrategy);
        return billManager.generateBill(reservation);
    }

    public Payment makePayment(Bill bill, double paymentAmount, PaymentStrategy paymentStrategy) {
        paymentManager.setPaymentStrategy(paymentStrategy);
        Payment payment = paymentManager.makePayment(bill, paymentAmount);
        if(!bill.isBillPaid()) {
            throw new RuntimeException("Payment Failed!!");
        }
        reservationManager.remove(bill.getReservationId());
        return payment;
    }

    public VehicleInventoryManager getInventoryManager() {
        return this.inventoryManager;
    }

    public int getStoreId() {
        return this.storeId;
    }
}
