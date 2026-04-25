package com.sarthak.inventorymgmt.dto;

import java.util.List;
import lombok.Data;

@Data
public class SaleRequestDto {
    private Long customerId;
    private Double totalAmount;
    private Double paidAmount;
    private Double dueAmount;
    private String paymentMethod;
    private String status;
    private List<SaleItemDto> items;

    @Data
    public static class SaleItemDto {
        private Long productId;
        private Integer quantity;
        private Double sellingPrice;
    }
}
