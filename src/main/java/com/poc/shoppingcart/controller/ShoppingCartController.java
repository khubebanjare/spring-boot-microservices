package com.poc.shoppingcart.controller;

import java.util.List;

import com.poc.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.poc.shoppingcart.entity.Product;
import com.poc.shoppingcart.entity.ShoppingCart;
import com.poc.shoppingcart.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class ShoppingCartController {

	@Autowired
	ProductService productService;
	@Autowired
	ShoppingCartService shoppingCartService;

	@GetMapping(value = "/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = productService.getAllProducts();
		return ResponseEntity.ok(productList);
	}

	@GetMapping(value = "/getAllShoppingProducts")
	public ResponseEntity<List<ShoppingCart>> getAllShoppingProducts() {
		List<ShoppingCart> productList = shoppingCartService.getAllShoppingProducts();
		for(ShoppingCart cart : productList){
			if(productList.contains(cart.getShoppingCartId()))
				productList.remove(cart.getQuantity());
		}
		return ResponseEntity.ok(productList);
	}

	@PostMapping("/addProductsTable")
	public List<Product> addProductsTable(@RequestBody List<Product> products) {
		return productService.saveProducts(products);
	}

	// @PostMapping(value="/addProduct", consumes={"application/json"})
	@PostMapping(value = "/addProduct")
	public ShoppingCart addProduct(@RequestBody ShoppingCart product) {
		return shoppingCartService.saveProduct(product);
	}

	@PostMapping("/addProducts")
	public List<ShoppingCart> addProducts(@RequestBody List<ShoppingCart> products) {
		return shoppingCartService.saveProducts(products);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		return shoppingCartService.deleteProduct(id);
	}

	@DeleteMapping("/deleteAllShoppingCart")
	public String deleteAllProduct() {
		return shoppingCartService.deleteAllProduct();
	}

	@GetMapping(value = "/productCount")
	public String productCountOfShoppingCart() {
		return shoppingCartService.productCountOfShoppingCart();
	}

	@GetMapping(value = "/products/category")
	@ResponseBody
	public List<Product> getProductsByCategory(@RequestParam(value = "category") String category) {
		System.out.println(productService.getProductsByCategory(category));
		return productService.getProductsByCategory(category);
	}

	@PutMapping(value = "/increaseQuantity/{cartId}")
	public String increaseQuantity(@PathVariable Integer cartId, @RequestParam Integer quantity) {
		shoppingCartService.increaseQuantity(cartId, quantity);
		return "quantity is increase : " + quantity;
	}

	@PutMapping(value = "/reduceQuantity/{cartId}")
	public String reduceQuantity(@PathVariable Integer cartId, @RequestParam Integer quantity) {
		shoppingCartService.reduceQuantity(cartId, quantity);
		 return "quantity is decrease : " + quantity;
	}
}
