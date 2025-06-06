package BookMyShow;

import BookMyShow.Enums.City;

import java.util.List;

public class Theatre {
    int id;
    City city;
    List<Screen> screens;
    List<Show> shows;

    public int getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
