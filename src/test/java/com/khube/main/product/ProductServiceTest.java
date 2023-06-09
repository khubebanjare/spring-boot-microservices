package com.khube.main.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.khube.main.product.entity.Product;
import com.khube.main.product.repository.ProductRepository;
import com.khube.main.product.response.ProductResponse;
import com.khube.main.product.service.impl.ProductServiceImpl;


@SpringBootTest(classes = ProductServiceTest.class)
public class ProductServiceTest {

	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductServiceImpl productService;
	
	@Test
	@Order(1)
	public void test_getProductsTest() {
		Product product1 = new Product();
		product1.setProductId(1);
		product1.setProductName("Iphone 14");
		product1.setIsActive(true);
		
		Product product2 = new Product();
		product2.setProductId(2);
		product2.setProductName("Iphone 14 Pro");
		product2.setIsActive(true);
		
		Product product3 = new Product();
		product3.setProductId(3);
		product3.setProductName("Iphone 14 Pro Max");
		product3.setIsActive(true);
		
		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		when(productRepository.findAll()).thenReturn(products);
		assertEquals(3,productService.getProducts().size());
	}
	
	@Test
	@Order(2)
	public void test_getProductById() {
		Product product1 = new Product();
		product1.setProductName("Iphone 14");
		product1.setIsActive(true);
		
		Integer productId = 2;
		
		Optional<Product> productOptionalId = Optional.of(product1);
		
		ProductResponse productResponse = productService.getProductById(productId).get();
		
		Mockito.when(productRepository.findById(productId)).thenReturn(productOptionalId);
		assertNotNull("Product with productId : " + productId + " not Found", productResponse);
		assertEquals(productId, productResponse.getProductId());
		assertEquals(product1.getProductName(), productResponse.getProductName());
		assertEquals(product1.getIsActive(), productResponse.getIsActive());
		
	}
}
