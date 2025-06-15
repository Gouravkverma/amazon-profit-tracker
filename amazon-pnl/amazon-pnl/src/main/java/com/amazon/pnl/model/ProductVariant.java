package com.amazon.pnl.model;

import jakarta.persistence.*;

@Entity
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;
    private String color;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
