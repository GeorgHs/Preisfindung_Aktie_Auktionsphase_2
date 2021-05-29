package com.georghs.vertx.pricing.components;

import java.time.LocalDateTime;

public class ExecutionPrice {
	private int price;
	private LocalDateTime date_time_being_created;

	/**
	 * Price at that's being executed around 9 am
	 * @param price as int
	 * @param date_time_being_created as LocalDateTime
	 */
	public ExecutionPrice(int price, LocalDateTime date_time_being_created) {
		super();
		this.price = price;
		this.date_time_being_created = date_time_being_created;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDateTime getDate_time_being_created() {
		return date_time_being_created;
	}
	public void setDate_time_being_created(LocalDateTime date_time_being_created) {
		this.date_time_being_created = date_time_being_created;
	}




}
