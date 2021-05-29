package com.georghs.vertx.pricing.participants;


public abstract class AbstractMarketParticipant {
	private int id;
	private String name;

	/**
	* Market-participant is selling or buying stocks on the market
	* @param id as int
	* @param name as String
	*/
	public AbstractMarketParticipant(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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


}
