package com.sarthak.inventorymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.inventorymgmt.entity.Sales;
import com.sarthak.inventorymgmt.repository.SalesRepo;
import com.sarthak.inventorymgmt.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesRepo repo;

    @Override
    public Sales save(Sales entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<Sales> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Sales> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
