package com.georghs.vertx.pricing.services;

import java.util.ArrayList;

import com.georghs.vertx.pricing.components.ExecutedOrderItem;
import com.georghs.vertx.pricing.components.ExecutionPrice;
import com.georghs.vertx.pricing.components.Order;

public class AuctionServiceImpl implements AuctionService {
	private ArrayList<ExecutedOrderItem> executedOrderItems = new ArrayList<>();
	private ArrayList<Order> allOrdersInPipe;
	private ExecutionPrice the_price;

// per Dependency Injection die Repositories mit reinziehen!!!


	public AuctionServiceImpl(ArrayList<ExecutedOrderItem> executedOrderItems, ArrayList<Order> allOrdersInPipe,
			ExecutionPrice the_price) {
		super();
		this.executedOrderItems = executedOrderItems;
		this.allOrdersInPipe = allOrdersInPipe;
		this.the_price = the_price;
	}

	public ArrayList<ExecutedOrderItem> getExecutedOrderItems() {
		return executedOrderItems;
	}

	public void setExecutedOrderItems(ArrayList<ExecutedOrderItem> executedOrderItems) {
		this.executedOrderItems = executedOrderItems;
	}

	public ArrayList<Order> getAllOrdersInPipe() {
		return allOrdersInPipe;
	}

	public void setAllOrdersInPipe(ArrayList<Order> allOrdersInPipe) {
		this.allOrdersInPipe = allOrdersInPipe;
	}

	public ExecutionPrice getThe_price() {
		return the_price;
	}

	public void setThe_price(ExecutionPrice the_price) {
		this.the_price = the_price;
	}

	//...


}
