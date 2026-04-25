package com.sarthak.inventorymgmt.facade;

import com.sarthak.inventorymgmt.dto.SaleRequestDto;
import com.sarthak.inventorymgmt.entity.Sales;

public interface SaleFacade {
    Sales processSale(SaleRequestDto request);
}
