package com.sarthak.inventorymgmt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sarthak.inventorymgmt.entity.Customers;

@SpringBootTest
@Transactional
public class CustomersRepoTest {

    @Autowired
    private CustomersRepo customersRepo;

    @Test
    public void testSaveAndFind() {
        Customers customers = new Customers();
        customers.setName("Test Customer");
        customers.setPhone("1234567890");
        
        Customers savedCustomers = customersRepo.save(customers);
        assertThat(savedCustomers.getId()).isNotNull();

        Optional<Customers> found = customersRepo.findById(savedCustomers.getId());
        assertThat(found).isPresent();
    }

    @Test
    public void testSoftDelete() {
        Customers customers = new Customers();
        customers.setName("Test Customer");
        customers.setPhone("1234567890");
        Customers savedCustomers = customersRepo.save(customers);
        Long id = savedCustomers.getId();

        customersRepo.deleteById(id);

        Optional<Customers> found = customersRepo.findById(id);
        assertThat(found).isEmpty();
        
        List<Customers> all = customersRepo.findAll();
        boolean stillExists = all.stream().anyMatch(e -> e.getId().equals(id));
        assertThat(stillExists).isFalse();
    }
}
