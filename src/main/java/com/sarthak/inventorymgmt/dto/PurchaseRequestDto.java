package com.sarthak.inventorymgmt.dto;

import java.util.List;
import lombok.Data;

@Data
public class PurchaseRequestDto {
    private Long supplierId;
    private Double totalAmount;
    private String status;
    private List<PurchaseItemDto> items;

    @Data
    public static class PurchaseItemDto {
        private Long productId;
        private Integer quantity;
        private Double costPrice;
    }
}
