package com.sarthak.inventorymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.inventorymgmt.entity.Suppliers;
import com.sarthak.inventorymgmt.repository.SuppliersRepo;
import com.sarthak.inventorymgmt.service.SuppliersService;

@Service
public class SuppliersServiceImpl implements SuppliersService {

    @Autowired
    private SuppliersRepo repo;

    @Override
    public Suppliers save(Suppliers entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<Suppliers> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Suppliers> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
