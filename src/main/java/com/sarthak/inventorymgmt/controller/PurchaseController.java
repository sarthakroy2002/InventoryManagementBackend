package com.sarthak.inventorymgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.inventorymgmt.dto.PurchaseRequestDto;
import com.sarthak.inventorymgmt.entity.Purchases;
import com.sarthak.inventorymgmt.facade.PurchaseFacade;


@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseFacade facade;

    @PostMapping
    public ResponseEntity<Purchases> processPurchase(@RequestBody PurchaseRequestDto request) {
        return ResponseEntity.ok(facade.processPurchase(request));
    }
}
