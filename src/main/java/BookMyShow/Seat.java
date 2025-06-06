package BookMyShow;

import BookMyShow.Enums.SeatCategory;

public class Seat {
    int seatId;
    int price;
    int row;
    SeatCategory seatCategory;

    public int getSeatId() {
        return seatId;
    }

    public int getPrice() {
        return price;
    }

    public int getRow() {
        return row;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }
}
