package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Production;
import mk.finki.ukim.wp.lab.repository.ProductionRepository;
import mk.finki.ukim.wp.lab.service.ProductionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {
    private final ProductionRepository productionRepository;

    public ProductionServiceImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Production> findAll() {
        return productionRepository.findAll();
    }
}
