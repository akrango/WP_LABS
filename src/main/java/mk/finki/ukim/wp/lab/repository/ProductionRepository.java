package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Production;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductionRepository {
    public List<Production> findAll(){
        return DataHolder.productions;
    }
}
