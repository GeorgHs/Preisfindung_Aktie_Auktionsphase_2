package com.georghs.vertx.pricing.participants;

import java.util.ArrayList;
import java.util.HashMap;

public class Broker extends AbstractMarketParticipant {
	private boolean commission_basis;
	private HashMap<String, Double> customer_id_spread = new HashMap<String, Double>() {{
		put("A1", 0.25);
		put("B1", 0.01);
	}};


	// 1. WIE KANN ICH HASHMAP MIT KUNDEN INITIALISIEREN
	// 2. WIE KANN ICH FOLGENDES MACHEN: WENN ON COMMISSION BASIS ÖFFNET ER DIE KUNDEN-HASHMAP; Prop-Trading: er kann die Hashmap nicht bedienen

	/**
	Broker is Market-Participant who is selling and buying stocks for himself on a proprietary basis or on a commission basis
	@param id
	@param name
	@param commission_basis the parameters used by the method
	*/
	public Broker(int id, String name, boolean commission_basis, HashMap<String, Double> customer_id_spread) {
		super(id, name);
		this.commission_basis = commission_basis;
		if (isCommission_basis() == false) {
			this.customer_id_spread = null;
		}

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

	/**
	All Customers of this particular broker are listed here with their IDs
	@return the value returned by the method
	*/
	public HashMap<String, Double> getCustomer_id_spread() {
		return customer_id_spread;
	}

	/**
	All Customers
	@param Set all customers
	*/
	public void setCustomer_id_spread(HashMap<String, Double> customer_id_spread) {
		if (isCommission_basis() == true ) {
			this.customer_id_spread = customer_id_spread;
		} else {
			this.customer_id_spread = null;
		}
	}

}
