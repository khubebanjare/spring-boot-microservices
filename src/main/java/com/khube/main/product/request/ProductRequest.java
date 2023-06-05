package com.khube.main.product.request;

import org.springframework.stereotype.Component;

@Component
public class ProductRequest {
    private Integer productId;
    private String productName;
    private Boolean isActive;

    public ProductRequest() {
    }

    public ProductRequest(Integer productId, String productName, Boolean isActive) {
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
        return "ProductRequest{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
