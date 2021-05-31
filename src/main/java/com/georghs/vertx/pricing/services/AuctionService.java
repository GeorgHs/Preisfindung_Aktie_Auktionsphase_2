package com.georghs.vertx.pricing.services;

import java.util.ArrayList;

import com.georghs.vertx.pricing.components.ExecutedOrderItem;
import com.georghs.vertx.pricing.components.ExecutionPrice;
import com.georghs.vertx.pricing.components.Order;

public interface AuctionService {
	ArrayList<ExecutedOrderItem> executedOrderItems = new ArrayList<>();
	public static final ArrayList<Order> allOrdersInPipe = null;
	public static final ExecutionPrice the_price = null;

	public ArrayList<ExecutedOrderItem> getExecutedOrderItems();
	public void setExecutedOrderItems(ArrayList<ExecutedOrderItem> executedOrderItems);
	public ArrayList<Order> getAllOrdersInPipe();
	public void setAllOrdersInPipe(ArrayList<Order> allOrdersInPipe);
	public ExecutionPrice getThe_price();
	public void setThe_price(ExecutionPrice the_price);
	//....
}