package com.sarthak.inventorymgmt.facade;

import java.util.List;
import com.sarthak.inventorymgmt.entity.Categories;

public interface CategoriesFacade {
    Categories create(Categories entity);
    Categories getById(Long id);
    List<Categories> getAll();
    void delete(Long id);
}
