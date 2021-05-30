package com.georghs.vertx.pricing.repositories;

import java.util.ArrayList;
import java.util.List;

import com.georghs.vertx.pricing.customer.Customer;

public class InMemoryCustomerRepository implements CustomerRepository {

	private List<Customer> customers;

	public InMemoryCustomerRepository() {
		customers = new ArrayList<>();
	}

	@Override
	public List<Customer> getAll() {
		return new ArrayList<>(customers);
	}

	@Override
	public void add(Customer entry) {
		customers.add(entry);

	}

	@Override
	public Customer update(String name, Customer customer) {
		var result = get(name);

		result.setClient_Type(customer.getClient_Type());
		result.setName(customer.getName());
		return result;
	}

	@Override
	public Customer get(String name) {
		var result = customers.stream()
				.filter((singlecustomer) -> singlecustomer.getName() == name)
				.findFirst();

		if (result.isEmpty()) {
			throw new IllegalArgumentException("name does not match or is null!");
		}

		return result.get();
	}

	@Override
	public boolean delete(String name) {
		var result = get(name);
		return customers.remove(result);
	}



}
