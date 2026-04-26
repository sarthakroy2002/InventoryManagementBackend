package com.sarthak.inventorymgmt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sarthak.inventorymgmt.entity.PurchaseItems;

@SpringBootTest
@Transactional
public class PurchaseItemsRepoTest {

    @Autowired
    private PurchaseItemsRepo purchaseItemsRepo;

    @Test
    public void testSaveAndFind() {
        PurchaseItems purchaseItems = new PurchaseItems();
        purchaseItems.setQuantity(5);
        purchaseItems.setCostPrice(10.0);
        
        PurchaseItems savedPurchaseItems = purchaseItemsRepo.save(purchaseItems);
        assertThat(savedPurchaseItems.getId()).isNotNull();

        Optional<PurchaseItems> found = purchaseItemsRepo.findById(savedPurchaseItems.getId());
        assertThat(found).isPresent();
    }

    @Test
    public void testSoftDelete() {
        PurchaseItems purchaseItems = new PurchaseItems();
        purchaseItems.setQuantity(5);
        purchaseItems.setCostPrice(10.0);
        PurchaseItems savedPurchaseItems = purchaseItemsRepo.save(purchaseItems);
        Long id = savedPurchaseItems.getId();

        purchaseItemsRepo.deleteById(id);

        Optional<PurchaseItems> found = purchaseItemsRepo.findById(id);
        assertThat(found).isEmpty();
    }
}
