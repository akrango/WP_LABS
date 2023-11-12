package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.TicketOrder;
import mk.finki.ukim.wp.lab.service.TicketOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    private final TicketOrderService ticketOrderService;

    public TicketOrderController(TicketOrderService ticketOrderService) {
        this.ticketOrderService = ticketOrderService;
    }

    @GetMapping
    public String getTicketOrdersPage(Model model) {
        model.addAttribute("tickets", ticketOrderService.getTickets());
        return "orderConfirmation";
    }

    @PostMapping
    public String getTicketsOrdersByTitleAndNumberOfTickets(@RequestParam String movieTitle,
                                                            @RequestParam String numOfTickets,
                                                            Model model) {
        List<TicketOrder> movies = ticketOrderService.getTicketsByMovieAndNumOfTickets(movieTitle, numOfTickets);
        model.addAttribute("tickets", ticketOrderService.getTicketsByMovieAndNumOfTickets(movieTitle, numOfTickets));
        return "orderConfirmation";
    }
}
