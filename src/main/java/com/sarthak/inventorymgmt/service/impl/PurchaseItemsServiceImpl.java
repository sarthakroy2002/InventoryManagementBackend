package com.sarthak.inventorymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.inventorymgmt.entity.PurchaseItems;
import com.sarthak.inventorymgmt.repository.PurchaseItemsRepo;
import com.sarthak.inventorymgmt.service.PurchaseItemsService;

@Service
public class PurchaseItemsServiceImpl implements PurchaseItemsService {

    @Autowired
    private PurchaseItemsRepo repo;

    @Override
    public PurchaseItems save(PurchaseItems entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<PurchaseItems> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<PurchaseItems> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
