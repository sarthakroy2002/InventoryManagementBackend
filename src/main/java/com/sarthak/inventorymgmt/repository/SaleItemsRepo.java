package com.sarthak.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarthak.inventorymgmt.entity.SaleItems;

@Repository
public interface SaleItemsRepo extends JpaRepository<SaleItems, Long> {
}
