package com.sarthak.inventorymgmt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sarthak.inventorymgmt.entity.StockMovements;

@SpringBootTest
@Transactional
public class StockMovementsRepoTest {

    @Autowired
    private StockMovementsRepo stockMovementsRepo;

    @Test
    public void testSaveAndFind() {
        StockMovements stockMovements = new StockMovements();
        stockMovements.setChangeType("IN");
        stockMovements.setQuantity(10);
        
        StockMovements savedStockMovements = stockMovementsRepo.save(stockMovements);
        assertThat(savedStockMovements.getId()).isNotNull();

        Optional<StockMovements> found = stockMovementsRepo.findById(savedStockMovements.getId());
        assertThat(found).isPresent();
    }

    @Test
    public void testSoftDelete() {
        StockMovements stockMovements = new StockMovements();
        stockMovements.setChangeType("IN");
        stockMovements.setQuantity(10);
        StockMovements savedStockMovements = stockMovementsRepo.save(stockMovements);
        Long id = savedStockMovements.getId();

        stockMovementsRepo.deleteById(id);

        Optional<StockMovements> found = stockMovementsRepo.findById(id);
        assertThat(found).isEmpty();
    }
}
