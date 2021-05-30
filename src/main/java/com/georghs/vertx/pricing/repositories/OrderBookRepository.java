package com.georghs.vertx.pricing.repositories;

import java.util.List;


import com.georghs.vertx.pricing.components.Order;

public interface OrderBookRepository {
		List<Order> getAll();
		void add(final Order entry);
		Order update(int id, final Order order);
		Order get(int id);
		boolean delete(int id);
}
