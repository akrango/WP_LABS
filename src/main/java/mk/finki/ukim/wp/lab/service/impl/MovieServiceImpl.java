package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Movie;
import mk.finki.ukim.wp.lab.model.Production;
import mk.finki.ukim.wp.lab.model.exceptions.ProductionNotFoundException;
import mk.finki.ukim.wp.lab.repository.MovieRepository;
import mk.finki.ukim.wp.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
        return movieRepository.searchMovies(text);
    }

    @Override
    public List<Movie> searchMoviesByParameter(String text, String rating) {
        return movieRepository.searchMoviesByParameter(text, rating);
    }

    @Override
    public Optional<Movie> saveMovie(String title, String summary, Double rating, Long production) {
        Production prod = DataHolder.productions.stream()
                .filter(p -> p.getId().equals(production))
                .findFirst()
                .orElseThrow(() -> new ProductionNotFoundException(production));

        return movieRepository.saveMovie(title, summary, rating, prod);
    }

    @Override
    public Optional<Movie> findById(Long movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public void deleteById(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
