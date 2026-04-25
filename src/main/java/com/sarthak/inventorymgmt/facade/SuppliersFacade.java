package com.sarthak.inventorymgmt.facade;

import java.util.List;
import com.sarthak.inventorymgmt.entity.Suppliers;

public interface SuppliersFacade {
    Suppliers create(Suppliers entity);
    Suppliers getById(Long id);
    List<Suppliers> getAll();
    void delete(Long id);
}
