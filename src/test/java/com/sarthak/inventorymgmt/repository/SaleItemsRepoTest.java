package com.sarthak.inventorymgmt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sarthak.inventorymgmt.entity.SaleItems;

@SpringBootTest
@Transactional
public class SaleItemsRepoTest {

    @Autowired
    private SaleItemsRepo saleItemsRepo;

    @Test
    public void testSaveAndFind() {
        SaleItems saleItems = new SaleItems();
        saleItems.setQuantity(2);
        saleItems.setSellingPrice(20.0);
        
        SaleItems savedSaleItems = saleItemsRepo.save(saleItems);
        assertThat(savedSaleItems.getId()).isNotNull();

        Optional<SaleItems> found = saleItemsRepo.findById(savedSaleItems.getId());
        assertThat(found).isPresent();
    }

    @Test
    public void testSoftDelete() {
        SaleItems saleItems = new SaleItems();
        saleItems.setQuantity(2);
        saleItems.setSellingPrice(20.0);
        SaleItems savedSaleItems = saleItemsRepo.save(saleItems);
        Long id = savedSaleItems.getId();

        saleItemsRepo.deleteById(id);

        Optional<SaleItems> found = saleItemsRepo.findById(id);
        assertThat(found).isEmpty();
    }
}
