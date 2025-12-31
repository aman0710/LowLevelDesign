package LLDofVehicleRentalSystem.Vehicle;

import java.time.LocalDate;

public class DateInterval {
    private final LocalDate from;
    private final LocalDate to;

    public DateInterval(LocalDate from, LocalDate to) {
        if(to.isBefore(from)) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public boolean overlaps(DateInterval newDateInterval) {
        return !this.to.isBefore(newDateInterval.from) || !this.from.isAfter(newDateInterval.to);
    }
}
