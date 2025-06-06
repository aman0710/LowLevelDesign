package BookMyShow;

import BookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    List<Theatre> allTheatres;
    Map<City, List<Theatre>> cityVsTheatres;

    public TheatreController() {
        this.allTheatres = new ArrayList<>();
        this.cityVsTheatres = new HashMap<>();
    }

    public List<Theatre> getAllTheatres() {
        return allTheatres;
    }

    public Map<City, List<Theatre>> getCityVsTheatres() {
        return cityVsTheatres;
    }

    public void setAllTheatres(List<Theatre> allTheatres) {
        this.allTheatres = allTheatres;
    }

    public void setCityVsTheatres(Map<City, List<Theatre>> cityVsTheatres) {
        this.cityVsTheatres = cityVsTheatres;
    }

    public void addTheatre(City city, Theatre theatre) {
        this.allTheatres.add(theatre);
        List<Theatre> theatreListCity = cityVsTheatres.getOrDefault(city, new ArrayList<>());
        theatreListCity.add(theatre);
        cityVsTheatres.put(city, theatreListCity);
    }

    public Map<Theatre, List<Show>> getAllShows(City city, Movie movie) {
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
        List<Theatre> theatres = cityVsTheatres.get(city);

        for(Theatre theatre : theatres) {
            List<Show> requiredShows = new ArrayList<>();
            for(Show show : theatre.getShows()) {
                if(show.movie.getId() == movie.getId()) {
                    requiredShows.add(show);
                }
            }
            if(!requiredShows.isEmpty())
                theatreVsShows.put(theatre, requiredShows);
        }
        return theatreVsShows;
    }
}
