package BookMyShow;

import BookMyShow.Enums.City;
import BookMyShow.Enums.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    MovieController movieController;
    TheatreController theatreController;
    public BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
        initialise();
    }

    private void initialise() {
        createMovies();
        createTheatres();
    }

    public void createBooking(String movieName, City city) {

        List<Movie> movies = movieController.cityVsMovies.get(city);
        Movie interestedMovie = null;

        for(Movie movie1 : movies) {
            if(movie1.getMovieName().equalsIgnoreCase(movieName))
                interestedMovie = movie1;
        }

        if(interestedMovie == null) {
            System.out.println("No such movie exists in the city!! Try a different movie");
            return;
        }

        Map<Theatre, List<Show>> theatreVsShows = theatreController.getAllShows(city, interestedMovie);
        Map.Entry<Theatre, List<Show>> entry = theatreVsShows.entrySet().iterator().next();
        Show interestedShow = entry.getValue().get(0);

        int seatNumber = 1;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();

        if(bookedSeats.contains(seatNumber)) {
            System.out.println("Seat Already Booked, try another seat!!");
            return;
        }

        bookedSeats.add(seatNumber);
        Booking booking = new Booking();
        booking.setShow(interestedShow);
        List<Seat> myBookedSeats = new ArrayList<>();
        for(Seat seat : interestedShow.getScreen().getSeats()) {
            if(seat.getSeatId() == seatNumber)
                myBookedSeats.add(seat);
        }
        booking.setSelectedSeats(myBookedSeats);
        System.out.println("Booking Successful!!");
    }

    private void createMovies() {

        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setMovieName("AVENGERS");
        movie1.setDurationInMinutes(150);
        Movie movie2 = new Movie();
        movie2.setId(2);
        movie2.setMovieName("BAAHUBALI");
        movie2.setDurationInMinutes(120);
        movieController.addMovie(City.BANGALORE, movie1);
        movieController.addMovie(City.BANGALORE, movie2);
        movieController.addMovie(City.DELHI, movie1);
        movieController.addMovie(City.DELHI, movie2);
    }

    private void createTheatres() {
        Movie movie1 = movieController.getMovieByName("AVENGERS");
        Movie movie2 = movieController.getMovieByName("BAAHUBALI");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setScreens(createScreens());
        inoxTheatre.setCity(City.BANGALORE);
        inoxTheatre.setId(1);
        Show show1 = createShows(movie1, inoxTheatre.getScreens().get(0), 8, 1);
        Show show2 = createShows(movie2, inoxTheatre.getScreens().get(0), 14, 2);
        List<Show> shows = new ArrayList<>();
        shows.add(show1);
        shows.add(show2);
        inoxTheatre.setShows(shows);

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setScreens(createScreens());
        pvrTheatre.setCity(City.DELHI);
        pvrTheatre.setId(2);
        Show show3 = createShows(movie1, pvrTheatre.getScreens().get(0), 12, 3);
        Show show4 = createShows(movie2, pvrTheatre.getScreens().get(0), 18, 4);
        List<Show> showsPVR = new ArrayList<>();
        showsPVR.add(show3);
        showsPVR.add(show4);
        pvrTheatre.setShows(showsPVR);

        theatreController.addTheatre(City.DELHI, pvrTheatre);
        theatreController.addTheatre(City.BANGALORE, inoxTheatre);
    }

    private Show createShows(Movie movie, Screen screen, int time, int showId) {
        List<Show> shows = new ArrayList<>();
        Show show = new Show();
        show.setId(showId);
        show.setMovie(movie);
        show.setScreen(screen);
        show.setTime(time);
        show.setBookedSeatIds(new ArrayList<>());
        return show;
    }

    private List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        Screen screen = new Screen();
        screen.setId(1);
        screen.setSeats(createSeats());
        screens.add(screen);
        return screens;
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        for(int i=1; i<=40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setRow(1);
            seat.setPrice(200);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }
        for(int i=41; i<=70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setRow(2);
            seat.setPrice(300);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }
        for(int i=71; i<=100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setRow(3);
            seat.setPrice(400);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }
        return seats;
    }

}
