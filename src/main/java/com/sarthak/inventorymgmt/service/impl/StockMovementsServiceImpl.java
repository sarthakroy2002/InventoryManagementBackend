package com.sarthak.inventorymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.inventorymgmt.entity.StockMovements;
import com.sarthak.inventorymgmt.repository.StockMovementsRepo;
import com.sarthak.inventorymgmt.service.StockMovementsService;

@Service
public class StockMovementsServiceImpl implements StockMovementsService {

    @Autowired
    private StockMovementsRepo repo;

    @Override
    public StockMovements save(StockMovements entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<StockMovements> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<StockMovements> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
