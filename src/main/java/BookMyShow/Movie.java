package BookMyShow;

public class Movie {
    int id;
    String movieName;
    int durationInMinutes;

    public int getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
