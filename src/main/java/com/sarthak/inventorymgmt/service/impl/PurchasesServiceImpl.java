package com.sarthak.inventorymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.inventorymgmt.entity.Purchases;
import com.sarthak.inventorymgmt.repository.PurchasesRepo;
import com.sarthak.inventorymgmt.service.PurchasesService;

@Service
public class PurchasesServiceImpl implements PurchasesService {

    @Autowired
    private PurchasesRepo repo;

    @Override
    public Purchases save(Purchases entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<Purchases> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Purchases> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
