package com.georghs.vertx.pricing.participants;

import java.util.ArrayList;
import java.util.HashMap;

import com.georghs.vertx.pricing.components.Currency;
import com.georghs.vertx.pricing.components.Order;
import com.georghs.vertx.pricing.components.OrderType;
import com.georghs.vertx.pricing.components.Stock;
import com.georghs.vertx.pricing.customer.Customer;
import com.georghs.vertx.pricing.customer.CustomerType;

public class Broker extends AbstractMarketParticipant {
	private boolean commission_basis;
//	private ArrayList<Order> customer_with_order = new ArrayList<>() {{
//		add(new Order(new Stock("sdfsdf", "sdfsfdf", Currency.AUD), 250, 25, OrderType.BUY_LIMIT, new Customer(CustomerType.Retail_Client,"Lisa")));
//	}};


	// 1. WIE KANN ICH HASHMAP MIT KUNDEN INITIALISIEREN
	// 2. WIE KANN ICH FOLGENDES MACHEN: WENN ON COMMISSION BASIS ÖFFNET ER DIE KUNDEN-HASHMAP; Prop-Trading: er kann die Hashmap nicht bedienen

	/**
	* Broker is Market-Participant who is selling and buying stocks for himself on a proprietary basis or on a commission basis
	* Broker holds Orders!
	* @param id
	* @param name
	* @param commission_basis the parameters used by the method
	*/
	public Broker(int id, String name, boolean commission_basis, ArrayList<Order> orders) {
		super(id, name, orders);
		this.commission_basis = commission_basis;


	}

	/**
	Is this a Commission-Trader or a Prop Trader?
	@return true, if it is on a commission basis, false if on a proprietary basis
	*/
	public boolean isCommission_basis() {
		return commission_basis;
	}

	/**
	Is this a Commission-Trader or a Prop Trader?
	@param true, if it is on a commission basis, false if on a proprietary basis
	*/
	public void setCommission_basis(boolean commission_basis) {
		this.commission_basis = commission_basis;
	}




}
