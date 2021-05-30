package com.georghs.vertx.pricing.repositories;

import java.util.List;

import com.georghs.vertx.pricing.components.Stock;

public interface StockRepository {
		List<Stock> getAll();
		void add(final Stock entry);
		Stock update(String ticker, final Stock stock);
		Stock get(String ticker);
		boolean delete(String ticker);
}
