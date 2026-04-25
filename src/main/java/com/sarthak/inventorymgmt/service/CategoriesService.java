package com.sarthak.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import com.sarthak.inventorymgmt.entity.Categories;

public interface CategoriesService {
    Categories save(Categories entity);
    Optional<Categories> findById(Long id);
    List<Categories> findAll();
    void deleteById(Long id);
}
