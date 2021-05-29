package com.georghs.vertx.pricing.InMemories;

import java.util.HashMap;
import java.util.Map;

import com.georghs.vertx.pricing.components.Currency;
import com.georghs.vertx.pricing.components.Order;
import com.georghs.vertx.pricing.components.Stock;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class InMemoryStocksStore {
	private double lastPrice;
	private Map<Long, Order> orderbooks = new HashMap<>();

	// Create newStock(), wie macht man das?

	InMemoryStocksStore() {


		Stock stock = new Stock("sdfs","name1", Currency.AUD);
		stock.setCur(Currency.CAD);

		Order order = new Order(stock,marketparticipant,3);

//		books.put(1L, );
//		books.put(2L, new Stock(2L, "Building Microservices"));
	}

	public JsonArray getAll() {
		JsonArray all = new JsonArray();
		orderbooks.values().forEach(book -> {
			all.add(JsonObject.mapFrom(book));
		});
		return all;
	}

	public void add(final Stock entry) {
		orderbooks.put(marketpa, entry);
	}

	public Stock update(String isbn, final Stock entry) {
		Long key = Long.parseLong(isbn);
		if (key != entry.getIsbn()) {
			throw new IllegalArgumentException("ISBN does not match!");
		}
		orderbooks.put(key, entry);
		return entry;
	}

	public Stock get(String isbn) {
		Long key = Long.parseLong(isbn);
		return order.get(key);
	}

	public Stock delete(final String isbn) {
		Long key = Long.parseLong(isbn);
		return orderbooks.remove(key);
	}
}
