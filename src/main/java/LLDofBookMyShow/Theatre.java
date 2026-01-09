package LLDofBookMyShow;

import LLDofBookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Theatre {
    int id;
    String address;
    City city;
    List<Show> shows;
    List<Screen> screens;

    public Theatre() {
        this.shows = new ArrayList<>();
        this.screens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
