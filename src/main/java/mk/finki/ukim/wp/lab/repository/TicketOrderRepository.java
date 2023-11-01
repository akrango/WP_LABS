package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.TicketOrder;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;

@Repository
public class TicketOrderRepository {
    public TicketOrder saveTicketOrder(TicketOrder ticketOrder){
        DataHolder.ticketOrder=ticketOrder;
        return ticketOrder;
    }

    public TicketOrder getTicketOrder() {
        return DataHolder.ticketOrder;
    }
}
