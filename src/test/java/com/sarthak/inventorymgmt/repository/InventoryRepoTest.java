package com.sarthak.inventorymgmt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sarthak.inventorymgmt.entity.Inventory;

@SpringBootTest
@Transactional
public class InventoryRepoTest {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Test
    public void testSaveAndFind() {
        Inventory inventory = new Inventory();
        inventory.setQuantity(10);
        inventory.setLocation("Test Location");
        
        Inventory savedInventory = inventoryRepo.save(inventory);
        assertThat(savedInventory.getId()).isNotNull();

        Optional<Inventory> found = inventoryRepo.findById(savedInventory.getId());
        assertThat(found).isPresent();
    }

    @Test
    public void testSoftDelete() {
        Inventory inventory = new Inventory();
        inventory.setQuantity(10);
        inventory.setLocation("Test Location");
        Inventory savedInventory = inventoryRepo.save(inventory);
        Long id = savedInventory.getId();

        inventoryRepo.deleteById(id);

        Optional<Inventory> found = inventoryRepo.findById(id);
        assertThat(found).isEmpty();
    }
}
