package com.sarthak.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarthak.inventorymgmt.entity.StockMovements;

@Repository
public interface StockMovementsRepo extends JpaRepository<StockMovements, Long> {
}
