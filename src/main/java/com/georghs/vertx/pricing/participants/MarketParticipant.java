package com.georghs.vertx.pricing.participants;


public abstract class MarketParticipant {
	private int id;
	private String name;

	/**
	Market-participant is selling or buying stocks on the market
	@param id ID of
	@param name
	*/
	public MarketParticipant(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	Market-Participant's id
	return id
	*/
	public final int getId() {
		return id;
	}
	/**
	Market-Participant's id
	@param id resetting the id
	*/
	public final void setId(int id) {
		this.id = id;
	}
	/**
	get the name
	@return name
	*/
	public final String getName() {
		return name;
	}
	/**
	Set the Name of the Market-Participant
	@param name
	*/
	public final void setName(String name) {
		this.name = name;
	}


}
