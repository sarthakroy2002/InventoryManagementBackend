package com.sarthak.inventorymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.inventorymgmt.entity.Inventory;
import com.sarthak.inventorymgmt.repository.InventoryRepo;
import com.sarthak.inventorymgmt.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepo repo;

    @Override
    public Inventory save(Inventory entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<Inventory> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Inventory> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
