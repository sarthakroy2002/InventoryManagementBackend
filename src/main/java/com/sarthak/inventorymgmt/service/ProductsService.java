package com.sarthak.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import com.sarthak.inventorymgmt.entity.Products;

public interface ProductsService {
    Products save(Products entity);
    Optional<Products> findById(Long id);
    List<Products> findAll();
    void deleteById(Long id);
}
