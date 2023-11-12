package mk.finki.ukim.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.wp.lab.model.Movie;
import mk.finki.ukim.wp.lab.model.TicketOrder;
import mk.finki.ukim.wp.lab.service.MovieService;
import mk.finki.ukim.wp.lab.service.ProductionService;
import mk.finki.ukim.wp.lab.service.TicketOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final ProductionService productionService;
    private final TicketOrderService ticketOrderService;

    public MovieController(MovieService movieService, ProductionService productionService, TicketOrderService ticketOrderService) {
        this.movieService = movieService;
        this.productionService = productionService;
        this.ticketOrderService = ticketOrderService;
    }

    //TODO: Implement error
    @GetMapping
    public String getMoviesPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("error", error);
        }
        model.addAttribute("movies", movieService.listAll());
        return "listMovies";
    }

    @PostMapping
    public String getMoviesByTitleAndRating(@RequestParam(required = false) String title,
                                            @RequestParam(required = false) String rating,
                                            Model model) {
        model.addAttribute("movies", movieService.searchMoviesByParameter(title, rating));
        return "listMovies";
    }

    @GetMapping("/add")
    public String saveMovie(Model model) {
        model.addAttribute("productions", productionService.findAll());
        return "add-movie";
    }

    @PostMapping("/save")
    public String save(@RequestParam String title,
                       @RequestParam String summary,
                       @RequestParam Double rating,
                       @RequestParam Long production) {
        movieService.saveMovie(title, summary, rating, production);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{movieId}")
    public String edit(@PathVariable Long movieId, Model model) {
        Optional<Movie> movie = movieService.findById(movieId);
        if (movie.isPresent()) {
            model.addAttribute("movie", movie.get());
            model.addAttribute("productions", productionService.findAll());
            return "add-movie";
        }
        return "redirect:/movies?error=MovieNotFound";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        movieService.deleteById(id);
        return "redirect:/movies";
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestParam(required = false) String selectedMovie,
                             @RequestParam String clientName,
                             @RequestParam String numTickets,
                             HttpServletRequest request) {

        String address = request.getRemoteAddr();
        TicketOrder ticket = ticketOrderService.placeOrder(selectedMovie, clientName, address, numTickets);
        if (ticket == null)
            return "redirect:/movies";

        return "redirect:/ticketOrder";
    }
}
