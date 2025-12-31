package LLDofVehicleRentalSystem;

import LLDofVehicleRentalSystem.Bill.Bill;
import LLDofVehicleRentalSystem.Bill.DailyBillingStrategy;
import LLDofVehicleRentalSystem.Payment.Payment;
import LLDofVehicleRentalSystem.Payment.UPIPaymentStrategy;
import LLDofVehicleRentalSystem.Reservation.Reservation;
import LLDofVehicleRentalSystem.Reservation.ReservationType;
import LLDofVehicleRentalSystem.Vehicle.DateInterval;
import LLDofVehicleRentalSystem.Vehicle.Vehicle;
import LLDofVehicleRentalSystem.Vehicle.VehicleType;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n===== LLD: Car Rental System Demo =====");

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem();
        // ---------------------------------------------------------
        // 1. Create Stores in System
        // ---------------------------------------------------------

        // Create a store1
        Location storeLocation1 = new Location(45,
                "Area1",
                "City1",
                "State1",
                "India",
                12345
        );
        Store store1 = new Store(1001, storeLocation1);
        rentalSystem.addStore(store1);

        // ---------------------------------------------------------
        // 2. Create Users in System
        // ---------------------------------------------------------

        // Create 2 users
        User user1 = new User(101, "AK", "JH001ABCD");
        User user2 = new User(102, "KA", "KA005ABCD");
        rentalSystem.addUser(user1);
        rentalSystem.addUser(user2);

        // ---------------------------------------------------------
        // 3. Add vehicles to store inventory
        // ---------------------------------------------------------
        Vehicle v1 = new Vehicle(1, "JH001QWER", VehicleType.FOUR_WHEELER);
        v1.setDailyRentalCost(1100);
        Vehicle v2 = new Vehicle(2, "KA007QWER", VehicleType.FOUR_WHEELER);
        v2.setDailyRentalCost(1400);

        store1.getInventoryManager().addVehicle(v1);
        store1.getInventoryManager().addVehicle(v2);

        // ---------------------------------------------------------
        // 4. User selects store and searches vehicles
        // ---------------------------------------------------------
        Store selectedStore = rentalSystem.getStore(1001);
        LocalDate from = LocalDate.of(2025, 12, 5);
        LocalDate to = LocalDate.of(2025, 12, 7);

        System.out.println("\nAvailable vehicles from: " + from + " to: " + to + " is as follows:");
        for(Vehicle v:selectedStore.getVehicles(VehicleType.FOUR_WHEELER, from, to)) {
            System.out.println(" - " + v.getVehicleId() + " : " + v.getVehicleType());
        }

        // ---------------------------------------------------------
        // 5. User creates reservation
        // ---------------------------------------------------------
        System.out.println("\nCreating Reservation...");
        Reservation reservation = selectedStore.createReservation(1, user1, from, to, ReservationType.DAILY);
        System.out.println("Reservation created with ID: " + reservation.getReservationId());

        // ---------------------------------------------------------
        // 6. User starts the trip
        // ---------------------------------------------------------
        System.out.println("\nStarting the trip...");
        selectedStore.startTrip(reservation.getReservationId());

        // ---------------------------------------------------------
        // 7. User submits the vehicle
        // ---------------------------------------------------------
        System.out.println("\nSubmitting the vehicle...");
        selectedStore.submitVehicle(reservation.getReservationId());

        // ---------------------------------------------------------
        // 8. System generates the bill
        // ---------------------------------------------------------
        System.out.println("\nGenerating the bill...");
        Bill bill = selectedStore.generateBill(reservation.getReservationId(), new DailyBillingStrategy(selectedStore.getInventoryManager()));
        System.out.println("Bill ID: " + bill.getBillId());
        System.out.println("Bill Amount: " + bill.getTotalBillAmount());

        // ---------------------------------------------------------
        // 9. User makes payment
        // ---------------------------------------------------------
        System.out.println("\nProcessing payment...");
        Payment payment = selectedStore.makePayment(bill, bill.getTotalBillAmount(), new UPIPaymentStrategy());
        System.out.println("\n===== PAYMENT RECEIPT =====");
        System.out.println("Payment ID: " + payment.getPaymentId());
        System.out.println("Paid Amount: " + payment.getAmountPaid());
        System.out.println("Payment Mode: " + payment.getPaymentMode());
        System.out.println("Payment Date: " + payment.getPaymentDate());
        System.out.println("============================");

    }
}
