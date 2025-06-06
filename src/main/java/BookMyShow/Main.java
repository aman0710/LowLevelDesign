package BookMyShow;

import BookMyShow.Enums.City;

public class Main {

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.createBooking("BAAHUBALI", City.BANGALORE);
        bookMyShow.createBooking("AVENGERS", City.BANGALORE);
    }
}
