package com.khube.main.product.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_tab")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private Boolean isActive;

    public Product() {
    }

    public Product(Integer productId, String productName, Boolean isActive) {
        this.productId = productId;
        this.productName = productName;
        this.isActive = isActive;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
