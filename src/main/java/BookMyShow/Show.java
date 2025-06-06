package BookMyShow;

import java.util.List;

public class Show {
    int id;
    Movie movie;
    Screen screen;
    int time;
    List<Integer> bookedSeatIds;

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setBookedSeatIds(List<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }

    public int getTime() {
        return time;
    }


    public void setTime(int time) {
        this.time = time;
    }
}
