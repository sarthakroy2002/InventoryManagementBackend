package com.sarthak.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import com.sarthak.inventorymgmt.entity.Suppliers;

public interface SuppliersService {
    Suppliers save(Suppliers entity);
    Optional<Suppliers> findById(Long id);
    List<Suppliers> findAll();
    void deleteById(Long id);
}
