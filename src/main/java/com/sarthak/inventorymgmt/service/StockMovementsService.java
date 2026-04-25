package com.sarthak.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import com.sarthak.inventorymgmt.entity.StockMovements;

public interface StockMovementsService {
    StockMovements save(StockMovements entity);
    Optional<StockMovements> findById(Long id);
    List<StockMovements> findAll();
    void deleteById(Long id);
}
