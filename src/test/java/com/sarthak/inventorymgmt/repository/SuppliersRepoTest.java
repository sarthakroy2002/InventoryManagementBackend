package com.sarthak.inventorymgmt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sarthak.inventorymgmt.entity.Suppliers;

@SpringBootTest
@Transactional
public class SuppliersRepoTest {

    @Autowired
    private SuppliersRepo suppliersRepo;

    @Test
    public void testSaveAndFind() {
        Suppliers suppliers = new Suppliers();
        suppliers.setName("Test Supplier");
        suppliers.setEmail("test@test.com");
        
        Suppliers savedSuppliers = suppliersRepo.save(suppliers);
        assertThat(savedSuppliers.getId()).isNotNull();

        Optional<Suppliers> found = suppliersRepo.findById(savedSuppliers.getId());
        assertThat(found).isPresent();
    }

    @Test
    public void testSoftDelete() {
        Suppliers suppliers = new Suppliers();
        suppliers.setName("Test Supplier");
        suppliers.setEmail("test@test.com");
        Suppliers savedSuppliers = suppliersRepo.save(suppliers);
        Long id = savedSuppliers.getId();

        suppliersRepo.deleteById(id);

        Optional<Suppliers> found = suppliersRepo.findById(id);
        assertThat(found).isEmpty();
        
        List<Suppliers> all = suppliersRepo.findAll();
        boolean stillExists = all.stream().anyMatch(e -> e.getId().equals(id));
        assertThat(stillExists).isFalse();
    }
}
