package com.sarthak.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarthak.inventorymgmt.entity.PurchaseItems;

@Repository
public interface PurchaseItemsRepo extends JpaRepository<PurchaseItems, Long> {
}
