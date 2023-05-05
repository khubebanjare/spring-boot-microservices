package com.poc.shoppingcart.service;

import com.poc.shoppingcart.entity.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {

    public ShoppingCart saveProduct(ShoppingCart product);
    public List<ShoppingCart> saveProducts(List<ShoppingCart> products);

    public List<ShoppingCart> getAllShoppingProducts();

    public String deleteProduct(int id);

    public String deleteAllProduct();

    public String productCountOfShoppingCart();

    public Optional<ShoppingCart> getProductById(Integer id);

    public void increaseQuantity(Integer cartId, Integer quantity);

    public void reduceQuantity(Integer cartId, Integer quantity);
}
