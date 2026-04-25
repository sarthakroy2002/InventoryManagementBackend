package com.sarthak.inventorymgmt.facade.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sarthak.inventorymgmt.dto.PurchaseRequestDto;
import com.sarthak.inventorymgmt.entity.Inventory;
import com.sarthak.inventorymgmt.entity.Products;
import com.sarthak.inventorymgmt.entity.PurchaseItems;
import com.sarthak.inventorymgmt.entity.Purchases;
import com.sarthak.inventorymgmt.entity.StockMovements;
import com.sarthak.inventorymgmt.entity.Suppliers;
import com.sarthak.inventorymgmt.facade.PurchaseFacade;
import com.sarthak.inventorymgmt.service.InventoryService;
import com.sarthak.inventorymgmt.service.ProductsService;
import com.sarthak.inventorymgmt.service.PurchaseItemsService;
import com.sarthak.inventorymgmt.service.PurchasesService;
import com.sarthak.inventorymgmt.service.StockMovementsService;
import com.sarthak.inventorymgmt.service.SuppliersService;


@Service
public class PurchaseFacadeImpl implements PurchaseFacade {

    @Autowired
    private PurchasesService purchaseService;
    @Autowired
    private PurchaseItemsService purchaseItemService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private StockMovementsService stockMovementService;
    @Autowired
    private SuppliersService supplierService;
    @Autowired
    private ProductsService productService;

    @Override
    @Transactional
    public Purchases processPurchase(PurchaseRequestDto request) {
        // 1. Fetch Supplier
        Suppliers supplier = supplierService.findById(request.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        // 2. Save Purchase Record
        Purchases purchase = new Purchases();
        purchase.setSupplier(supplier);
        purchase.setTotalAmount(request.getTotalAmount());
        purchase.setStatus(request.getStatus());
        purchase = purchaseService.save(purchase);

        // 3. Process each item
        for (PurchaseRequestDto.PurchaseItemDto itemDto : request.getItems()) {
            Products product = productService.findById(itemDto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            // 3a. Save Purchase Item
            PurchaseItems item = new PurchaseItems();
            item.setPurchase(purchase);
            item.setProduct(product);
            item.setQuantity(itemDto.getQuantity());
            item.setCostPrice(itemDto.getCostPrice());
            purchaseItemService.save(item);

            // 3b. Update Inventory
            Optional<Inventory> optInventory = inventoryService.findAll().stream()
                    .filter(inv -> inv.getProduct().getId().equals(product.getId()))
                    .findFirst();

            Inventory inventory;
            if (optInventory.isPresent()) {
                inventory = optInventory.get();
                inventory.setQuantity(inventory.getQuantity() + itemDto.getQuantity());
            } else {
                inventory = new Inventory();
                inventory.setProduct(product);
                inventory.setQuantity(itemDto.getQuantity());
                inventory.setLocation("Default Location");
            }
            inventoryService.save(inventory);

            // 3c. Record Stock Movement
            StockMovements movement = new StockMovements();
            movement.setProduct(product);
            movement.setChangeType("PURCHASE_IN");
            movement.setQuantity(itemDto.getQuantity());
            movement.setReferenceId(purchase.getId());
            stockMovementService.save(movement);
        }

        return purchase;
    }
}
