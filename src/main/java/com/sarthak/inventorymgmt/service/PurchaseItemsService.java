package com.sarthak.inventorymgmt.service;

import java.util.List;
import java.util.Optional;
import com.sarthak.inventorymgmt.entity.PurchaseItems;

public interface PurchaseItemsService {
    PurchaseItems save(PurchaseItems entity);
    Optional<PurchaseItems> findById(Long id);
    List<PurchaseItems> findAll();
    void deleteById(Long id);
}
