package com.sarthak.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import com.sarthak.inventorymgmt.entity.Purchases;

public interface PurchasesService {
    Purchases save(Purchases entity);
    Optional<Purchases> findById(Long id);
    List<Purchases> findAll();
    void deleteById(Long id);
}
