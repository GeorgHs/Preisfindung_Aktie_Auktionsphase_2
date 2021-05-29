package com.georghs.vertx.pricing.components;

import com.georghs.vertx.pricing.participants.MarketParticipant;

/**
 * Eingehende Order die im Buch aufgenommen wird
 */
public class Order {
	private Stock stock;
	private MarketParticipant marketparticipant;
	private int amount;

	public Order(Stock stock, MarketParticipant marketparticipant, int amount) {
		super();
		this.stock = stock;
		this.marketparticipant = marketparticipant;
		this.amount = amount;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public MarketParticipant getMarketparticipant() {
		return marketparticipant;
	}
	public void setMarketparticipant(MarketParticipant marketparticipant) {
		this.marketparticipant = marketparticipant;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}




}
