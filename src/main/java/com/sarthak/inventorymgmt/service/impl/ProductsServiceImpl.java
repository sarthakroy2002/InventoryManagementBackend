package com.sarthak.inventorymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.inventorymgmt.entity.Products;
import com.sarthak.inventorymgmt.repository.ProductsRepo;
import com.sarthak.inventorymgmt.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepo repo;

    @Override
    public Products save(Products entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<Products> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Products> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
