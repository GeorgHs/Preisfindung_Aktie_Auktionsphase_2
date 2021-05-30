package com.georghs.vertx.pricing.repositories;

import java.util.ArrayList;
import java.util.List;


import com.georghs.vertx.pricing.components.Stock;


public class InMemoryStockRepository implements StockRepository {
	private List<Stock> stocks;

	public InMemoryStockRepository() {
		stocks = new ArrayList<>();
	}

	@Override
	public List<Stock> getAll() {
		return new ArrayList<>(stocks);
	}

	@Override
	public void add(Stock entry) {
		stocks.add(entry);
	}

	@Override
	public Stock update(String ticker, Stock stock) {
		var result = get(ticker);

		result.setCur(stock.getCur());
		result.setName(stock.getName());
		result.setTicker(stock.getTicker());
		return result;
	}

	@Override
	public Stock get(String ticker) {
		var result = stocks.stream()
				.filter((singlestock) -> singlestock.getTicker() == ticker)
				.findFirst();

		if (result.isEmpty()) {
			throw new IllegalArgumentException("ticker does not match or is null!");
		}
		return result.get();
	}

	@Override
	public boolean delete(String ticker) {
		var result = get(ticker);
		return stocks.remove(result);
	}

}
