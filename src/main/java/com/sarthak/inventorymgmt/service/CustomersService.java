package com.sarthak.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import com.sarthak.inventorymgmt.entity.Customers;

public interface CustomersService {
    Customers save(Customers entity);
    Optional<Customers> findById(Long id);
    List<Customers> findAll();
    void deleteById(Long id);
}
