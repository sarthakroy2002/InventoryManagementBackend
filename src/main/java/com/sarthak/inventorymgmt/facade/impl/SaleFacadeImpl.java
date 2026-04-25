package com.sarthak.inventorymgmt.facade.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sarthak.inventorymgmt.dto.SaleRequestDto;
import com.sarthak.inventorymgmt.entity.Customers;
import com.sarthak.inventorymgmt.entity.Inventory;
import com.sarthak.inventorymgmt.entity.Products;
import com.sarthak.inventorymgmt.entity.SaleItems;
import com.sarthak.inventorymgmt.entity.Sales;
import com.sarthak.inventorymgmt.entity.StockMovements;
import com.sarthak.inventorymgmt.facade.SaleFacade;
import com.sarthak.inventorymgmt.service.CustomersService;
import com.sarthak.inventorymgmt.service.InventoryService;
import com.sarthak.inventorymgmt.service.ProductsService;
import com.sarthak.inventorymgmt.service.SaleItemsService;
import com.sarthak.inventorymgmt.service.SalesService;
import com.sarthak.inventorymgmt.service.StockMovementsService;


@Service
public class SaleFacadeImpl implements SaleFacade {

    @Autowired
    private SalesService saleService;
    @Autowired
    private SaleItemsService saleItemService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private StockMovementsService stockMovementService;
    @Autowired
    private CustomersService customerService;
    @Autowired
    private ProductsService productService;

    @Override
    @Transactional
    public Sales processSale(SaleRequestDto request) {
        // 1. Fetch Customer
        Customers customer = customerService.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // 2. Pre-check inventory for all items before saving anything
        for (SaleRequestDto.SaleItemDto itemDto : request.getItems()) {
            Optional<Inventory> optInventory = inventoryService.findAll().stream()
                    .filter(inv -> inv.getProduct().getId().equals(itemDto.getProductId()))
                    .findFirst();
            
            if (optInventory.isEmpty() || optInventory.get().getQuantity() < itemDto.getQuantity()) {
                throw new RuntimeException("Insufficient inventory for product ID: " + itemDto.getProductId());
            }
        }

        // 3. Save Sale Record
        Sales sale = new Sales();
        sale.setCustomer(customer);
        sale.setTotalAmount(request.getTotalAmount());
        sale.setPaidAmount(request.getPaidAmount());
        sale.setDueAmount(request.getDueAmount());
        sale.setPaymentMethod(request.getPaymentMethod());
        sale.setStatus(request.getStatus());
        sale.setInvoiceNumber("INV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        sale = saleService.save(sale);

        // 4. Process each item
        for (SaleRequestDto.SaleItemDto itemDto : request.getItems()) {
            Products product = productService.findById(itemDto.getProductId()).get(); // already validated

            // 4a. Save Sale Item
            SaleItems item = new SaleItems();
            item.setSale(sale);
            item.setProduct(product);
            item.setQuantity(itemDto.getQuantity());
            item.setSellingPrice(itemDto.getSellingPrice());
            saleItemService.save(item);

            // 4b. Deduct Inventory
            Inventory inventory = inventoryService.findAll().stream()
                    .filter(inv -> inv.getProduct().getId().equals(product.getId()))
                    .findFirst().get();
            inventory.setQuantity(inventory.getQuantity() - itemDto.getQuantity());
            inventoryService.save(inventory);

            // 4c. Record Stock Movement
            StockMovements movement = new StockMovements();
            movement.setProduct(product);
            movement.setChangeType("SALE_OUT");
            movement.setQuantity(itemDto.getQuantity());
            movement.setReferenceId(sale.getId());
            stockMovementService.save(movement);
        }

        return sale;
    }
}
