package com.sarthak.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import com.sarthak.inventorymgmt.entity.Sales;

public interface SalesService {
    Sales save(Sales entity);
    Optional<Sales> findById(Long id);
    List<Sales> findAll();
    void deleteById(Long id);
}
