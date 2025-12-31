package LLDofVehicleRentalSystem.Vehicle;

import LLDofVehicleRentalSystem.Reservation.Reservation;
import LLDofVehicleRentalSystem.Reservation.ReservationRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class VehicleInventoryManager {
    private final ConcurrentMap<Integer, Vehicle> vehicles = new ConcurrentHashMap<>();
    private final ConcurrentMap<Integer, ReentrantLock> vehicleLocks = new ConcurrentHashMap<>();
    private final ConcurrentMap<Integer, List<Integer>> vehicleBookingIds = new ConcurrentHashMap<>();
    private ReservationRepository reservationRepository;

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.put(vehicle.getVehicleId(), vehicle);
    }

    public Optional<Vehicle> getVehicle(int vehicleId) {
        return Optional.ofNullable(vehicles.get(vehicleId));
    }

    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    private ReentrantLock getLockForVehicle(int vehicleId) {
        vehicleLocks.putIfAbsent(vehicleId, new ReentrantLock());
        return vehicleLocks.get(vehicleId);
    }

    public boolean isAvailable(int vehicleId, LocalDate from, LocalDate to) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if(vehicle == null || vehicle.getVehicleStatus() == VehicleStatus.MAINTENANCE)
            return false;

        DateInterval requested = new DateInterval(from, to);
        List<Integer> reservationIds = vehicleBookingIds.get(vehicleId);
        if(reservationIds == null || reservationIds.isEmpty())
            return true;

        for(int reservationId: reservationIds) {
            Reservation reservation = reservationRepository.findById(reservationId).get();
            LocalDate bookedFrom = reservation.getBookedFrom();
            LocalDate bookedTo = reservation.getBookedTo();
            DateInterval bookedInterval = new DateInterval(bookedFrom, bookedTo);
            if(bookedInterval.overlaps(requested))
                return false;
        }
        return true;
    }

    public boolean reserve(int vehicleId, int reservationId, LocalDate from, LocalDate to) {
        ReentrantLock lock = getLockForVehicle(vehicleId);
        lock.lock();
        try{
            if(!isAvailable(vehicleId, from, to)) {
                return false;
            }
            vehicleBookingIds.putIfAbsent(vehicleId, new ArrayList<>());
            vehicleBookingIds.get(vehicleId).add(reservationId);
            vehicles.get(vehicleId).setVehicleStatus(VehicleStatus.BOOKED);
            return true;
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public void release(int vehicleId, int reservationId) {
        ReentrantLock lock = getLockForVehicle(vehicleId);
        lock.lock();
        try {
            List<Integer> reservationIds = vehicleBookingIds.get(vehicleId);
            if(reservationIds != null) {
                reservationIds.remove(Integer.valueOf(reservationId));
            }
            List<Integer> stillBooked = vehicleBookingIds.get(vehicleId);
            if(stillBooked == null || stillBooked.isEmpty()) {
                vehicles.get(vehicleId).setVehicleStatus(VehicleStatus.AVAILABLE);
            }
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public List<Vehicle> getAvailableVehiclesList(VehicleType vehicleType, LocalDate from, LocalDate to) {
        return vehicles.values().stream().filter(v -> v.getVehicleType() == vehicleType).filter(v -> isAvailable(v.getVehicleId(), from, to)).collect(Collectors.toList());
    }
}
