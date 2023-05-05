package com.poc.shoppingcart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.poc.shoppingcart.entity.ShoppingCart;
import com.poc.shoppingcart.repository.ShoppingCartRepository;
import com.poc.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.shoppingcart.exception.CartIsEmpty;
import com.poc.shoppingcart.exception.ProductNotFoundException;
import com.poc.shoppingcart.exception.ProductOutOfStock;
import com.poc.shoppingcart.repository.ProductRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	 @Autowired
	 private ShoppingCartRepository shoppingCartRepository;
	 @Autowired
	 private ProductRepository productRepository;

	 public static ShoppingCart cart;

	private ShoppingCart saveGetTotal(ShoppingCart product){
		cart = getCart(product);
		int count = countProductCart();
			cart.setQuantity(cart.getQuantity() + count);
			cart.setAvailableQuantity(cart.getAvailableQuantity() - count);
		return cart;
	}

	private ShoppingCart getCart(ShoppingCart product){
		ShoppingCart cart = shoppingCartRepository.save(product);
		cart = shoppingCartRepository.findById(cart.getShoppingCartId())
				.orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
		return cart;
	}

	public int countProductCart(){
		Long count = shoppingCartRepository.count();
		int countCart = count.intValue();
		return countCart;
	}

	public ShoppingCart saveProduct(ShoppingCart product) {
		return saveGetTotal(product);
	}

	public List<ShoppingCart> saveProducts(List<ShoppingCart> products) {
		return shoppingCartRepository.saveAll(products);
	}

	public List<ShoppingCart> getAllShoppingProducts() {
		List<ShoppingCart> carts = new ArrayList<>();
		int count = countProductCart();
		for(ShoppingCart cart : shoppingCartRepository.findAll()){
			carts.add(cart);
			cart.setAvailableQuantity(cart.getAvailableQuantity() - count);
			cart.setQuantity(cart.getQuantity() + count);

		}
		return carts;
	}

	public String deleteProduct(int id) {
		shoppingCartRepository.deleteById(id);
		return "Product removed!! " + id;
	}

	public String deleteAllProduct() {
		shoppingCartRepository.deleteAll();
		return "Products removed!!";
	}

	public String productCountOfShoppingCart() {
		int count = countProductCart();
		return "Product Count of Shopping Cart : " + count;
	}

	public Optional<ShoppingCart> getProductById(Integer id){
		return shoppingCartRepository.findById(id);
	}

	public void increaseQuantity(Integer cartId, Integer quantity) {
		cart = shoppingCartRepository.findById(cartId)
				.orElseThrow(() -> new ProductNotFoundException("Product Not Found"));

		if(cart.getAvailableQuantity() < quantity)
			throw new ProductOutOfStock("Out Of Stock");

		if(cart.getAvailableQuantity() - 1 <= 0 || cart.getAvailableQuantity()  <= 0 && quantity > 0
				|| quantity <= 0 || quantity >= cart.getAvailableQuantity())
			throw new CartIsEmpty("Out Of Stock");

		cart.setQuantity(cart.getQuantity() + quantity);
		cart.setAvailableQuantity(cart.getAvailableQuantity() - quantity);

		saveGetTotal(cart);
		//  || cart.getTotal() > quantity && cart.getTotal() + 1  < quantity  || cart.getTotal() + 1  < quantity || quantity <= 0
	}

	public void reduceQuantity(Integer cartId, Integer quantity) {
		cart = shoppingCartRepository.findById(cartId)
				.orElseThrow(() -> new ProductNotFoundException("Product Not Found"));

//		if(cart.getAvailableQuantity() < quantity)
//			throw new CartIsEmpty("Cart is Empty one");

		if(cart.getQuantity() < 0 || cart.getQuantity() > quantity && cart.getQuantity() + 1  < quantity  || cart.getQuantity() + 1  < quantity || quantity <= 0)
			throw new CartIsEmpty("Cart is Empty");

		cart.setQuantity(cart.getQuantity() - quantity);
		cart.setAvailableQuantity(cart.getAvailableQuantity() + quantity);
		saveGetTotal(cart);
	}
}
