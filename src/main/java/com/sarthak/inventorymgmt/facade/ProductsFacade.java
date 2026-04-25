package com.sarthak.inventorymgmt.facade;

import java.util.List;
import com.sarthak.inventorymgmt.entity.Products;

public interface ProductsFacade {
    Products create(Products entity);
    Products getById(Long id);
    List<Products> getAll();
    void delete(Long id);
}
