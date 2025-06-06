package BookMyShow;

import BookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    List<Movie> allMovies;
    Map<City, List<Movie>> cityVsMovies;

    public MovieController() {
        this.allMovies = new ArrayList<>();
        this.cityVsMovies = new HashMap<>();
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public Map<City, List<Movie>> getCityVsMovies() {
        return cityVsMovies;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public void setCityVsMovies(Map<City, List<Movie>> cityVsMovies) {
        this.cityVsMovies = cityVsMovies;
    }

    public void addMovie(City city, Movie movie) {
        this.allMovies.add(movie);
        List<Movie> movieListCity = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movieListCity.add(movie);
        this.cityVsMovies.put(city, movieListCity);
    }

    public Movie getMovieByName(String movieName) {
        for(Movie movie: allMovies) {
            if(movie.getMovieName().equalsIgnoreCase(movieName))
                return movie;
        }
        return null;
    }
}
