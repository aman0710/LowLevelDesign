package LLDofVehicleRentalSystem.Reservation;

import java.time.LocalDate;

public class Reservation {
    private final int reservationId;
    private final int vehicleId;
    private final int userId;
    private final LocalDate bookedFrom;
    private final LocalDate bookedTo;
    private final ReservationType reservationType;
    private ReservationStatus reservationStatus;

    public Reservation(int reservationId, int vehicleId, int userId, LocalDate bookedFrom, LocalDate bookedTo, ReservationType reservationType) {
        this.reservationId = reservationId;
        this.vehicleId = vehicleId;
        this.userId = userId;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.reservationType = reservationType;
        this.reservationStatus = ReservationStatus.SCHEDULED;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getBookedFrom() {
        return bookedFrom;
    }

    public LocalDate getBookedTo() {
        return bookedTo;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
