package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.TicketOrder;

import java.util.List;

public interface TicketOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, String address, String numberOfTickets);
    List<TicketOrder> getTickets();

    List<TicketOrder> getTicketsByMovieAndNumOfTickets(String movieTitle, String numOfTickets);
}
