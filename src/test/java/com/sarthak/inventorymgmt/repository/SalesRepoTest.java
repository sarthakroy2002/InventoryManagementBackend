package com.sarthak.inventorymgmt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sarthak.inventorymgmt.entity.Sales;

@SpringBootTest
@Transactional
public class SalesRepoTest {

    @Autowired
    private SalesRepo salesRepo;

    @Test
    public void testSaveAndFind() {
        Sales sales = new Sales();
        sales.setTotalAmount(50.0);
        sales.setStatus("Completed");
        
        Sales savedSales = salesRepo.save(sales);
        assertThat(savedSales.getId()).isNotNull();

        Optional<Sales> found = salesRepo.findById(savedSales.getId());
        assertThat(found).isPresent();
    }

    @Test
    public void testSoftDelete() {
        Sales sales = new Sales();
        sales.setTotalAmount(50.0);
        sales.setStatus("Completed");
        Sales savedSales = salesRepo.save(sales);
        Long id = savedSales.getId();

        salesRepo.deleteById(id);

        Optional<Sales> found = salesRepo.findById(id);
        assertThat(found).isEmpty();
        
        List<Sales> all = salesRepo.findAll();
        boolean stillExists = all.stream().anyMatch(e -> e.getId().equals(id));
        assertThat(stillExists).isFalse();
    }
}
