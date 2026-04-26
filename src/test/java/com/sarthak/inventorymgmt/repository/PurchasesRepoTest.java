package com.sarthak.inventorymgmt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sarthak.inventorymgmt.entity.Purchases;

@SpringBootTest
@Transactional
public class PurchasesRepoTest {

    @Autowired
    private PurchasesRepo purchasesRepo;

    @Test
    public void testSaveAndFind() {
        Purchases purchases = new Purchases();
        purchases.setTotalAmount(100.0);
        purchases.setStatus("Pending");
        
        Purchases savedPurchases = purchasesRepo.save(purchases);
        assertThat(savedPurchases.getId()).isNotNull();

        Optional<Purchases> found = purchasesRepo.findById(savedPurchases.getId());
        assertThat(found).isPresent();
    }

    @Test
    public void testSoftDelete() {
        Purchases purchases = new Purchases();
        purchases.setTotalAmount(100.0);
        purchases.setStatus("Pending");
        Purchases savedPurchases = purchasesRepo.save(purchases);
        Long id = savedPurchases.getId();

        purchasesRepo.deleteById(id);

        Optional<Purchases> found = purchasesRepo.findById(id);
        assertThat(found).isEmpty();
        
        List<Purchases> all = purchasesRepo.findAll();
        boolean stillExists = all.stream().anyMatch(e -> e.getId().equals(id));
        assertThat(stillExists).isFalse();
    }
}
