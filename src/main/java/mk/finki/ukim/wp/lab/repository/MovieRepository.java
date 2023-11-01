package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {

    public List<Movie> findAll(){
        return DataHolder.movies;
    }

    public List<Movie> searchMovies(String text){
        return DataHolder.movies.stream()
                .filter(m->m.getTitle().contains(text) || m.getSummary().contains(text))
                .collect(Collectors.toList());
    }

    public List<Movie> searchMoviesByParameter(String text, String rating) {
        if((text==null || text.isEmpty()) && (rating==null || rating.isEmpty())){
            return this.findAll();
        }
        return DataHolder.movies.stream()
                .filter(m -> text != null && m.getTitle().contains(text))
                .filter(m -> {
                    if (rating != null) {
                        try {
                            double parsedRating = Double.parseDouble(rating);
                            return m.getRating() >= parsedRating;
                        } catch (NumberFormatException e) {
                            // Handle the case where 'rating' is not a valid number
                            return true; // or take appropriate action
                        }
                    }
                    return false; // or take appropriate action when 'rating' is null
                })
                .collect(Collectors.toList());

    }
}
