package LLDofBookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int id;
    List<Seat> seats;

    public Screen() {
        this.seats = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
