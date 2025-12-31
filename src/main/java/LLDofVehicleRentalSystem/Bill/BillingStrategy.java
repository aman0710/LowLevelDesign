package LLDofVehicleRentalSystem.Bill;

import LLDofVehicleRentalSystem.Reservation.Reservation;

public interface BillingStrategy {
    Bill generateBill(Reservation reservation);
}
