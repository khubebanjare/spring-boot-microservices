package com.poc.shoppingcart.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_tab", uniqueConstraints={@UniqueConstraint(columnNames={"refId"})})
public class Order {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@NotNull(message = "Please Enter Reference Id")
	private String refId;
	private String orderName;
	@OneToMany
	private List<ShoppingCart> shoppingCart;
	private Double subTotal;

	public Order() {
	}

	public Order(Long orderId, String refId, String orderName, List<ShoppingCart> shoppingCart, Double subTotal) {
		this.orderId = orderId;
		this.refId = refId;
		this.orderName = orderName;
		this.shoppingCart = shoppingCart;
		this.subTotal = subTotal;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public List<ShoppingCart> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(List<ShoppingCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderId=" + orderId +
				", refId='" + refId + '\'' +
				", orderName='" + orderName + '\'' +
				", shoppingCart=" + shoppingCart +
				", subTotal=" + subTotal +
				'}';
	}
}

