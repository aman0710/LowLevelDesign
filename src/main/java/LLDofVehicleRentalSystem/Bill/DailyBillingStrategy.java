package LLDofVehicleRentalSystem.Bill;

import LLDofVehicleRentalSystem.Reservation.Reservation;
import LLDofVehicleRentalSystem.Vehicle.Vehicle;
import LLDofVehicleRentalSystem.Vehicle.VehicleInventoryManager;
import LLDofVehicleRentalSystem.Vehicle.VehicleType;
import LLDofVehicleRentalSystem.VehicleRentalSystem;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DailyBillingStrategy implements BillingStrategy{

    VehicleInventoryManager inventoryManager;
    private final AtomicInteger billIdGenerator = new AtomicInteger(50000);

    public DailyBillingStrategy(VehicleInventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    @Override
    public Bill generateBill(Reservation reservation) {
        long days = ChronoUnit.DAYS.between(reservation.getBookedFrom(), reservation.getBookedTo()) + 1;
        Vehicle vehicle = inventoryManager.getVehicle(reservation.getVehicleId()).get();
        double dailyFare = vehicle.getDailyRentalCost();
        double totalFare = dailyFare * days;
        return new Bill(billIdGenerator.getAndIncrement(), reservation.getReservationId(), totalFare);
    }
}
