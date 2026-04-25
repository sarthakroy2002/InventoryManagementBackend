package com.sarthak.inventorymgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.inventorymgmt.entity.Categories;
import com.sarthak.inventorymgmt.repository.CategoriesRepo;
import com.sarthak.inventorymgmt.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepo repo;

    @Override
    public Categories save(Categories entity) {
        return repo.save(entity);
    }

    @Override
    public Optional<Categories> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Categories> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
