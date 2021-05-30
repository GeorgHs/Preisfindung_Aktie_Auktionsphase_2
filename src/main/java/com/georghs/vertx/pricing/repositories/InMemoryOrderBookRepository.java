package com.georghs.vertx.pricing.repositories;

import java.util.ArrayList;
import java.util.List;

import com.georghs.vertx.pricing.components.Order;
import com.georghs.vertx.pricing.components.OrderType;

public class InMemoryOrderBookRepository implements OrderBookRepository {

	private List<Order> orders;

	public InMemoryOrderBookRepository() {
		orders = new ArrayList<>();
	}

	@Override
	public List<Order> getAll() {
		return new ArrayList<>(orders);
	}

	@Override
	public void add(Order entry) {
		orders.add(entry);

	}

	@Override
	public Order update(int id, Order order) {
		var result = get(id);

		result.setCustomer(order.getCustomer());
		result.setOrdertype(order.getOrdertype());
		result.setPrice(order.getPrice());
		result.setStock(order.getStock());
		result.setVolume_in_amount(order.getVolume_in_amount());

		return result;
	}

	@Override
	public Order get(int id) {
		var result = orders.stream()
				.filter((singleorder) -> singleorder.getId() == id)
				.findFirst();

		if (result.isEmpty()) {
			throw new IllegalArgumentException("Id does not match or is null!");
		}

		return result.get();
	}

	@Override
	public boolean delete(int id) {
		var result = get(id);
		return orders.remove(result);
	}

}
