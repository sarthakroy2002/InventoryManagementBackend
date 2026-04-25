package com.sarthak.inventorymgmt.facade.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sarthak.inventorymgmt.entity.Suppliers;
import com.sarthak.inventorymgmt.facade.SuppliersFacade;
import com.sarthak.inventorymgmt.service.SuppliersService;

@Service
public class SuppliersFacadeImpl implements SuppliersFacade {

    @Autowired
    private SuppliersService service;

    @Override
    public Suppliers create(Suppliers entity) {
        return service.save(entity);
    }

    @Override
    public Suppliers getById(Long id) {
        return service.findById(id).orElseThrow(() -> new RuntimeException("Suppliers not found"));
    }

    @Override
    public List<Suppliers> getAll() {
        return service.findAll();
    }

    @Override
    public void delete(Long id) {
        service.deleteById(id);
    }
}
