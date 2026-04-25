package com.sarthak.inventorymgmt.facade.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sarthak.inventorymgmt.entity.Inventory;
import com.sarthak.inventorymgmt.facade.InventoryFacade;
import com.sarthak.inventorymgmt.service.InventoryService;

@Service
public class InventoryFacadeImpl implements InventoryFacade {

    @Autowired
    private InventoryService service;

    @Override
    public Inventory create(Inventory entity) {
        return service.save(entity);
    }

    @Override
    public Inventory getById(Long id) {
        return service.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
    }

    @Override
    public List<Inventory> getAll() {
        return service.findAll();
    }

    @Override
    public void delete(Long id) {
        service.deleteById(id);
    }
}
