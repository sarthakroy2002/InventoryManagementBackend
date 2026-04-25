package com.sarthak.inventorymgmt.facade.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sarthak.inventorymgmt.entity.Products;
import com.sarthak.inventorymgmt.facade.ProductsFacade;
import com.sarthak.inventorymgmt.service.ProductsService;

@Service
public class ProductsFacadeImpl implements ProductsFacade {

    @Autowired
    private ProductsService service;

    @Override
    public Products create(Products entity) {
        return service.save(entity);
    }

    @Override
    public Products getById(Long id) {
        return service.findById(id).orElseThrow(() -> new RuntimeException("Products not found"));
    }

    @Override
    public List<Products> getAll() {
        return service.findAll();
    }

    @Override
    public void delete(Long id) {
        service.deleteById(id);
    }
}
