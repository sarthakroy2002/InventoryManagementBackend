package com.sarthak.inventorymgmt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sarthak.inventorymgmt.entity.Products;

@SpringBootTest
@Transactional
public class ProductsRepoTest {

    @Autowired
    private ProductsRepo productsRepo;

    @Test
    public void testSaveAndFind() {
        Products products = new Products();
        products.setName("Test Product");
        products.setSku("SKU-TEST");
        
        Products savedProducts = productsRepo.save(products);
        assertThat(savedProducts.getId()).isNotNull();

        Optional<Products> found = productsRepo.findById(savedProducts.getId());
        assertThat(found).isPresent();
    }

    @Test
    public void testSoftDelete() {
        Products products = new Products();
        products.setName("Test Product");
        products.setSku("SKU-TEST");
        Products savedProducts = productsRepo.save(products);
        Long id = savedProducts.getId();

        productsRepo.deleteById(id);

        Optional<Products> found = productsRepo.findById(id);
        assertThat(found).isEmpty();
        
        List<Products> all = productsRepo.findAll();
        boolean stillExists = all.stream().anyMatch(e -> e.getId().equals(id));
        assertThat(stillExists).isFalse();
    }
}
