package com.sarthak.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarthak.inventorymgmt.entity.Suppliers;

@Repository
public interface SuppliersRepo extends JpaRepository<Suppliers, Long> {
}
