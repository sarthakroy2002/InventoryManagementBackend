package com.sarthak.inventorymgmt.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.sarthak.inventorymgmt.entity.Suppliers;
import com.sarthak.inventorymgmt.facade.SuppliersFacade;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {

    @Autowired
    private SuppliersFacade facade;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody Suppliers entity) {
        try {
            Suppliers created = facade.create(entity);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create suppliers: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Suppliers entity = facade.getById(id);
            if (entity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No suppliers found for id: " + id);
            }
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch suppliers: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<Suppliers> list = facade.getAll();
            if (list == null || list.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No suppliers found");
            }
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch suppliers: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            facade.delete(id);
            return ResponseEntity.ok().body("Suppliers deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete suppliers: " + e.getMessage());
        }
    }
}
