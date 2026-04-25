package com.sarthak.inventorymgmt.facade;

import java.util.List;
import com.sarthak.inventorymgmt.entity.Customers;

public interface CustomersFacade {
    Customers create(Customers entity);
    Customers getById(Long id);
    List<Customers> getAll();
    void delete(Long id);
}
