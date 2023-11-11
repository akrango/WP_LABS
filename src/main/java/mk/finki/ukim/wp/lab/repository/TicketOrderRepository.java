package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.TicketOrder;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TicketOrderRepository {
    public TicketOrder saveTicketOrder(TicketOrder ticketOrder){
        DataHolder.ticketOrders.add(ticketOrder);
        return ticketOrder;
    }

    public List<TicketOrder> getTicketOrders() {
        return DataHolder.ticketOrders;
    }

    public List<TicketOrder> getTicketsByMovieAndNumOfTickets(String movieTitle, String numOfTickets) {
        if(movieTitle==null || movieTitle.isEmpty() || numOfTickets==null || numOfTickets.isEmpty()){
            return getTicketOrders();
        }
        Integer numTickets=Integer.parseInt(numOfTickets);
        return DataHolder.ticketOrders.stream()
                .filter(t->t.getMovieTitle().contains(movieTitle))
                .filter(t->t.getNumberOfTickets()>numTickets)
                .collect(Collectors.toList());
    }
}
