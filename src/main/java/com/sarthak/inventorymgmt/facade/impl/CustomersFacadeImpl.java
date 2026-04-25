package com.sarthak.inventorymgmt.facade.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sarthak.inventorymgmt.entity.Customers;
import com.sarthak.inventorymgmt.facade.CustomersFacade;
import com.sarthak.inventorymgmt.service.CustomersService;

@Service
public class CustomersFacadeImpl implements CustomersFacade {

    @Autowired
    private CustomersService service;

    @Override
    public Customers create(Customers entity) {
        return service.save(entity);
    }

    @Override
    public Customers getById(Long id) {
        return service.findById(id).orElseThrow(() -> new RuntimeException("Customers not found"));
    }

    @Override
    public List<Customers> getAll() {
        return service.findAll();
    }

    @Override
    public void delete(Long id) {
        service.deleteById(id);
    }
}
