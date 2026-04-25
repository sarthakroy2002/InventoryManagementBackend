package com.sarthak.inventorymgmt.facade.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sarthak.inventorymgmt.entity.Categories;
import com.sarthak.inventorymgmt.facade.CategoriesFacade;
import com.sarthak.inventorymgmt.service.CategoriesService;

@Service
public class CategoriesFacadeImpl implements CategoriesFacade {

    @Autowired
    private CategoriesService service;

    @Override
    public Categories create(Categories entity) {
        return service.save(entity);
    }

    @Override
    public Categories getById(Long id) {
        return service.findById(id).orElseThrow(() -> new RuntimeException("Categories not found"));
    }

    @Override
    public List<Categories> getAll() {
        return service.findAll();
    }

    @Override
    public void delete(Long id) {
        service.deleteById(id);
    }
}
