package com.sarthak.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarthak.inventorymgmt.entity.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {
}
