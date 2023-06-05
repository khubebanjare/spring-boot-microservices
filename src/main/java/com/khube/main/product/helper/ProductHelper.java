package com.khube.main.product.helper;

import com.khube.main.product.entity.Product;
import com.khube.main.product.request.ProductRequest;
import com.khube.main.product.response.ProductResponse;

public class ProductHelper {

    public static ProductRequest setProductDetailsForRequest(Product product){
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductId(product.getProductId());
        productRequest.setProductName(product.getProductName());
        productRequest.setIsActive(product.getIsActive());
        return productRequest;
    }

    public static ProductResponse setProductDetailsForResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getProductId());
        productResponse.setProductName(product.getProductName());
        productResponse.setIsActive(product.getIsActive());
        return productResponse;
    }

    /*public static ProductResponse setProductDetailsForMultiObjectResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getProductId());
        productResponse.setProductName(product.getProductName());
        productResponse.setIsActive(product.getIsActive());
        return productResponse;
    }*/
}
