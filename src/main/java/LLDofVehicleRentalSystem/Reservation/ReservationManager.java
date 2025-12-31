package LLDofVehicleRentalSystem.Reservation;

import LLDofVehicleRentalSystem.User;
import LLDofVehicleRentalSystem.Vehicle.VehicleInventoryManager;

import javax.management.relation.RelationTypeNotFoundException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationManager {
    private final VehicleInventoryManager inventoryManager;
    private final ReservationRepository reservationRepository;
    private final AtomicInteger reservationIdGenerator = new AtomicInteger(20000);

    public ReservationManager(VehicleInventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.reservationRepository = new ReservationRepository();
        this.inventoryManager.setReservationRepository(this.reservationRepository);
    }

    public Optional<Reservation> findById(int reservationId) {
        return this.reservationRepository.findById(reservationId);
    }

    public Reservation createReservation(int vehicleId, LocalDate from, LocalDate to, User user, ReservationType reservationType) {
        int reservationId = reservationIdGenerator.getAndIncrement();
        boolean reserved = inventoryManager.reserve(vehicleId, reservationId, from, to);
        if(!reserved) {
            throw new RuntimeException("Vehicle not available for the selected dates!!");
        }
        Reservation reservation = new Reservation(reservationId, vehicleId, user.getUserId(), from, to, reservationType);

        reservationRepository.save(reservation);
        return reservation;
    }

    public void cancelReservation(int reservationId) {
        Optional<Reservation> opt = reservationRepository.findById(reservationId);
        if(!opt.isPresent()) {
            throw new RuntimeException("Reservation not found!!");
        }
        Reservation reservation = opt.get();
        reservation.setReservationStatus(ReservationStatus.CANCELLED);
        inventoryManager.release(reservation.getVehicleId(), reservation.getReservationId());
        reservationRepository.remove(reservationId);
    }

    public void startTrip(int reservationId) {
        Optional<Reservation> opt = reservationRepository.findById(reservationId);
        if(!opt.isPresent()) {
            throw new RuntimeException("Reservation not found!!");
        }
        Reservation reservation = opt.get();
        reservation.setReservationStatus(ReservationStatus.IN_USE);
    }

    public void submitVehicle(int reservationId) {
        Optional<Reservation> opt = reservationRepository.findById(reservationId);
        if(!opt.isPresent()) {
            throw new RuntimeException("Reservation not found!!");
        }
        Reservation reservation = opt.get();
        reservation.setReservationStatus(ReservationStatus.COMPLETED);
        inventoryManager.release(reservation.getVehicleId(), reservation.getReservationId());
    }

    public void remove(int reservationId) {
        reservationRepository.remove(reservationId);
    }
}
