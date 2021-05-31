package com.georghs.vertx.pricing.participants;

import java.util.ArrayList;

import com.georghs.vertx.pricing.components.Order;

public abstract class AbstractMarketParticipant {
	private int id;
	private String name;
	private ArrayList<Order> orders;

	/**
	* Market-participant is selling or buying stocks on the market
	* @param id as int
	* @param name as String
	*/
	public AbstractMarketParticipant(int id, String name, ArrayList<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.orders = orders;
	}

	/**
	* Market-Participant's id
	* @return id as int
	*/
	public final int getId() {
		return id;
	}
	/**
	* Market-Participant's id
	* @param id as int
	*/
	public final void setId(int id) {
		this.id = id;
	}
	/**
	* get the name
	* @return name as String
	*/
	public final String getName() {
		return name;
	}
	/**
	* Set the Name of the Market-Participant
	* @param name as String
	*/
	public final void setName(String name) {
		this.name = name;
	}

	/**
	* all Orders of this Broker are listed, market-participant (customer) included in instance of order-class
	* @return returns orders of this particular broker
	*/
	public ArrayList<Order> getOrders() {
		return orders;
	}

	/**
	* all Orders of this Broker are listed, market-participant (customer) included in instance of order-class
	* @param orders of this particular broker
	*/
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

}
