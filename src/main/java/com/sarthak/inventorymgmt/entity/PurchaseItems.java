package com.sarthak.inventorymgmt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "purchase_items")
public class PurchaseItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "cost_price", nullable = false)
    private Double costPrice;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchases purchase;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;
}
