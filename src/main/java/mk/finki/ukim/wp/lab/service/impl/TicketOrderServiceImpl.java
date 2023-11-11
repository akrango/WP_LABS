package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.TicketOrder;
import mk.finki.ukim.wp.lab.repository.TicketOrderRepository;
import mk.finki.ukim.wp.lab.service.TicketOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {

    private final TicketOrderRepository ticketOrderRepository;

    public TicketOrderServiceImpl(TicketOrderRepository ticketOrderRepository) {
        this.ticketOrderRepository = ticketOrderRepository;
    }

    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, String numberOfTickets) {
        if(numberOfTickets.isEmpty()){
            return null;
        }
        TicketOrder ticketOrder=new TicketOrder(movieTitle,clientName,address, Long.parseLong(numberOfTickets));
        return ticketOrderRepository.saveTicketOrder(ticketOrder);
    }


    @Override
    public List<TicketOrder> getTickets() {
        return ticketOrderRepository.getTicketOrders();
    }

    @Override
    public List<TicketOrder> getTicketsByMovieAndNumOfTickets(String movieTitle, String numOfTickets) {
        return ticketOrderRepository.getTicketsByMovieAndNumOfTickets(movieTitle,numOfTickets);
    }
}
