package com.sarthak.inventorymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.inventorymgmt.entity.Customers;
import com.sarthak.inventorymgmt.repository.CustomersRepo;
import com.sarthak.inventorymgmt.service.CustomersService;

@Service
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepo repo;

    @Override
    public Customers save(Customers entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<Customers> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Customers> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
