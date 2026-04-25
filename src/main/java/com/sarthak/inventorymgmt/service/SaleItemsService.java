package com.sarthak.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import com.sarthak.inventorymgmt.entity.SaleItems;

public interface SaleItemsService {
    SaleItems save(SaleItems entity);
    Optional<SaleItems> findById(Long id);
    List<SaleItems> findAll();
    void deleteById(Long id);
}
