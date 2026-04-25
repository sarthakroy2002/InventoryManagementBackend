package com.sarthak.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarthak.inventorymgmt.entity.Categories;

public interface CategoriesRepo extends JpaRepository<Categories, Long> {

}
