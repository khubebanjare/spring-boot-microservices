package com.khube.main.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Product Api", 
		version = "1.0", 
		description = "Product MicroService Spring Boot Application",
		contact = @Contact (
				email = "info.khube@gmail.com",
				name = "MICROGRAPS",
				url = "http://localhost:8087/product-service"
				)))
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
