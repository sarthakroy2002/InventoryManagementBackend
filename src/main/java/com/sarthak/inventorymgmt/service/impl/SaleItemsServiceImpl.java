package com.sarthak.inventorymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.inventorymgmt.entity.SaleItems;
import com.sarthak.inventorymgmt.repository.SaleItemsRepo;
import com.sarthak.inventorymgmt.service.SaleItemsService;

@Service
public class SaleItemsServiceImpl implements SaleItemsService {

    @Autowired
    private SaleItemsRepo repo;

    @Override
    public SaleItems save(SaleItems entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<SaleItems> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<SaleItems> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
