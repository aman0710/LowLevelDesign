package LLDofBookMyShow;

import LLDofBookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatres;
    List<Theatre> allTheatres;

    public TheatreController() {
        this.cityVsTheatres = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city) {
        allTheatres.add(theatre);
        List<Theatre> theatres = cityVsTheatres.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatres.put(city, theatres);
    }

    Map<Theatre, List<Show>> getShowsByTheatre(City city, Movie movie) {
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
        List<Theatre> theatres = cityVsTheatres.get(city);
        for(Theatre theatre: theatres) {
            List<Show> shows = theatre.getShows();
            List<Show> selectedShows = new ArrayList<>();
            for(Show show: shows) {
                if(show.movie.getId() == movie.getId()) {
                    selectedShows.add(show);
                }
            }
            if(!selectedShows.isEmpty()) {
                theatreVsShows.put(theatre, selectedShows);
            }
        }
        return theatreVsShows;
    }
}
