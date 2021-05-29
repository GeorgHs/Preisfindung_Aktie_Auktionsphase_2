package com.georghs.vertx.pricing.customer;

public class Customer {
	private CustomerType client_Type;
	private String name;
	public Customer(CustomerType client_Type, String name) {
		super();
		this.client_Type = client_Type;
		this.name = name;
	}
	public CustomerType getClient_Type() {
		return client_Type;
	}
	public void setClient_Type(CustomerType client_Type) {
		this.client_Type = client_Type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
