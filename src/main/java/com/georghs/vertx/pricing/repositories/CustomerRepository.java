package com.georghs.vertx.pricing.repositories;

import java.util.List;

import com.georghs.vertx.pricing.customer.Customer;

public interface CustomerRepository {
	List<Customer> getAll();
	void add(final Customer entry);
	Customer update(String name, final Customer customer);
	Customer get(String name);
	boolean delete(String name);
}
