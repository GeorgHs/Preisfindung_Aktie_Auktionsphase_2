package com.georghs.vertx.pricing.components;

import com.georghs.vertx.pricing.participants.AbstractMarketParticipant;

/**
 * Eingehende Order die im Buch aufgenommen wird
 */
public class Order {
	private Stock stock;
	private AbstractMarketParticipant marketparticipant;
	private int amount;

	public Order(Stock stock, AbstractMarketParticipant marketparticipant, int amount) {
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
	public AbstractMarketParticipant getMarketparticipant() {
		return marketparticipant;
	}
	public void setMarketparticipant(AbstractMarketParticipant marketparticipant) {
		this.marketparticipant = marketparticipant;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}




}
