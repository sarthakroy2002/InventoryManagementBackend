package com.sarthak.inventorymgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.inventorymgmt.dto.SaleRequestDto;
import com.sarthak.inventorymgmt.entity.Sales;
import com.sarthak.inventorymgmt.facade.SaleFacade;


@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleFacade facade;

    @PostMapping
    public ResponseEntity<Sales> processSale(@RequestBody SaleRequestDto request) {
        return ResponseEntity.ok(facade.processSale(request));
    }
}
