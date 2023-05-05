package com.poc.shoppingcart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_tab")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String title;
	private int availableQuantity;
	private Double price;
	private String description;
	private String image;
	private String category;

	public Product() {
	}

	public Product(int productId, String title, int availableQuantity, Double price, String description, String image, String category) {
		this.productId = productId;
		this.title = title;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.description = description;
		this.image = image;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", title='" + title + '\'' +
				", availableQuantity=" + availableQuantity +
				", price=" + price +
				", description='" + description + '\'' +
				", image='" + image + '\'' +
				", category='" + category + '\'' +
				'}';
	}
}
