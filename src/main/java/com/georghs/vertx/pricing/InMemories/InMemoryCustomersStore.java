package com.georghs.vertx.pricing.InMemories;

import java.util.ArrayList;

import com.georghs.vertx.pricing.customer.Customer;

public class InMemoryCustomersStore {
	private ArrayList<Customer> customers;

	public InMemoryCustomersStore(ArrayList<Customer> customers) {
		super();
		this.customers = customers;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

}
