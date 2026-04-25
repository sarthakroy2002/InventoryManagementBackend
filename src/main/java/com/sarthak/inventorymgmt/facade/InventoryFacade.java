package com.sarthak.inventorymgmt.facade;

import java.util.List;
import com.sarthak.inventorymgmt.entity.Inventory;

public interface InventoryFacade {
    Inventory create(Inventory entity);
    Inventory getById(Long id);
    List<Inventory> getAll();
    void delete(Long id);
}
