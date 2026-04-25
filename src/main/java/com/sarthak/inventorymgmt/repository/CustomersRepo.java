package com.sarthak.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarthak.inventorymgmt.entity.Customers;

@Repository
public interface CustomersRepo extends JpaRepository<Customers, Long> {
}
