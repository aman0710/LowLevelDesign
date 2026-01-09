package LLDofBookMyShow;

import LLDofBookMyShow.Enums.City;

public class Main {
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();
        bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");
        bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");
    }
}
