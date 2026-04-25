package com.sarthak.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarthak.inventorymgmt.entity.Sales;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Long> {
}
