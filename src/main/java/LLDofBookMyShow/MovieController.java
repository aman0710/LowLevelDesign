package LLDofBookMyShow;

import LLDofBookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityVsMovies;
    List<Movie> allMovies;

    public MovieController() {
        this.cityVsMovies = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {
        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);
        allMovies.add(movie);
    }

    Movie getMovieByName(String movieName) {
        for(Movie movie: allMovies) {
            if(movie.getName().equalsIgnoreCase(movieName))
                return movie;
        }
        return null;
    }

    List<Movie> getMoviesByCity(City city) {
        return cityVsMovies.get(city);
    }
}
