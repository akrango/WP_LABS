package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Movie;
import mk.finki.ukim.wp.lab.model.TicketOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Movie> movies=null;
    public static TicketOrder ticketOrder=null;

    @PostConstruct
    public void init(){
        movies=new ArrayList<>();
        movies.add(new Movie("Title1","Summary1",4.5));
        movies.add(new Movie("Title2","Summary2",3.5));
        movies.add(new Movie("Title3","Summary3",2.0));
        movies.add(new Movie("Title4","Summary4",5.0));
        movies.add(new Movie("Title5","Summary5",2.5));
    }
}
