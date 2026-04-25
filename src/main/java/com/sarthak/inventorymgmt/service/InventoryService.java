package com.sarthak.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import com.sarthak.inventorymgmt.entity.Inventory;

public interface InventoryService {
    Inventory save(Inventory entity);
    Optional<Inventory> findById(Long id);
    List<Inventory> findAll();
    void deleteById(Long id);
}
