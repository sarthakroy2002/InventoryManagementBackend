package com.sarthak.inventorymgmt.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.sarthak.inventorymgmt.entity.Customers;
import com.sarthak.inventorymgmt.facade.CustomersFacade;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomersFacade facade;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody Customers entity) {
        try {
            Customers created = facade.create(entity);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create customers: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Customers entity = facade.getById(id);
            if (entity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customers found for id: " + id);
            }
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch customers: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<Customers> list = facade.getAll();
            if (list == null || list.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customers found");
            }
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch customers: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            facade.delete(id);
            return ResponseEntity.ok().body("Customers deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete customers: " + e.getMessage());
        }
    }
}
