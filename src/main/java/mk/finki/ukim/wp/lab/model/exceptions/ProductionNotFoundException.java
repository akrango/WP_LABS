package mk.finki.ukim.wp.lab.model.exceptions;

public class ProductionNotFoundException extends RuntimeException{
    public ProductionNotFoundException(Long productionId) {
        super(String.format("Production with id %d doesn't exist", productionId));
    }
}
