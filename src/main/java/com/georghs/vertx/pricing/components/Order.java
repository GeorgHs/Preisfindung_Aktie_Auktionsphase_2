package com.georghs.vertx.pricing.components;

import java.util.UUID;

import com.georghs.vertx.pricing.customer.Customer;
import com.georghs.vertx.pricing.participants.AbstractMarketParticipant;

/**
 * Eingehende Order die im Buch aufgenommen wird
 */
public class Order {
	private UUID id;
	private Stock stock;
	private int volume_in_amount;
	private int price;
	private OrderType ordertype;
	private Customer customer;


	public Order(Stock stock, int volume_in_amount, int price, OrderType ordertype, Customer customer) {
		super();
		this.id = UUID.randomUUID();
		this.stock = stock;
		this.volume_in_amount = volume_in_amount;
		this.price = price;
		this.ordertype = ordertype;
		this.customer = customer;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public int getVolume_in_amount() {
		return volume_in_amount;
	}
	public void setVolume_in_amount(int volume_in_amount) {
		this.volume_in_amount = volume_in_amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public OrderType getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(OrderType ordertype) {
		this.ordertype = ordertype;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public UUID getId() {
		return id;
	}


}
