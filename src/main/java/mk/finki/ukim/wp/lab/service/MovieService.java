package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Movie;
import mk.finki.ukim.wp.lab.model.Production;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> listAll();

    List<Movie> searchMovies(String text);

    List<Movie> searchMoviesByParameter(String text, String rating);

    Optional<Movie> saveMovie(String title, String summary, Double rating, Long production);

    Optional<Movie> findById(Long movieId);

    void deleteById(Long movieId);
}
