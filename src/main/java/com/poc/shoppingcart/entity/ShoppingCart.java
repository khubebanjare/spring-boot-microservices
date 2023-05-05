package com.poc.shoppingcart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shoppingCartId;
	@Column(name="title")
	private String title;
	@Column(name="availableQuantity")
	private int availableQuantity;
	@Column(name="price")
	private Double price;
	@Column(name="description")
	private String description;
	@Column(name="image")
	private String image;
	private int quantity;
	
	public ShoppingCart() {}
	public ShoppingCart(int shoppingCartId, String title, int availableQuantity, Double price, String description, String image, int quantity) {
		this.shoppingCartId = shoppingCartId;
		this.title = title;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.description = description;
		this.image = image;
		this.quantity = quantity;
	}

	public int getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ShoppingCart{" +
				"shoppingCartId=" + shoppingCartId +
				", title='" + title + '\'' +
				", availableQuantity=" + availableQuantity +
				", price=" + price +
				", description='" + description + '\'' +
				", image='" + image + '\'' +
				", quantity=" + quantity +
				'}';
	}
}
