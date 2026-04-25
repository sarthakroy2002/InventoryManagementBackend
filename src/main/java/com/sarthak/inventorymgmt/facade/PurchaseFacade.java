package com.sarthak.inventorymgmt.facade;

import com.sarthak.inventorymgmt.dto.PurchaseRequestDto;
import com.sarthak.inventorymgmt.entity.Purchases;

public interface PurchaseFacade {
    Purchases processPurchase(PurchaseRequestDto request);
}
