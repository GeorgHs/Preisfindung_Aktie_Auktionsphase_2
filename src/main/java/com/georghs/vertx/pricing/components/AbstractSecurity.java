package com.georghs.vertx.pricing.components;

public abstract class AbstractSecurity {
	private String ticker;
	private String name;
	private Currency cur;

	/**
	 * Security is an asset that can be traded on the market - it can be Fixed Income Asset/Equity Asset/Derivate like Option/Future, ...
	 * @param: ticker - ticker of that security
	 * @param: name - what's the name of the security
	 * @param: cur - What's the national currency that security is being traded in
	 */
	public AbstractSecurity(String ticker, String name, Currency cur) {
		super();
		this.ticker = ticker;
		this.name = name;
		this.cur = cur;
	}

	/**
	 * get ticker of this security
	 * @return ticker as String
	 */
	public String getTicker() {
		return ticker;
	}

	/**
	 * set ticker of this security
	 * @param ticker as String
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	/**
	 * get name of this security
	 * @return name as String
	 */
	public String getName() {
		return name;
	}

	/**
	 * set name of this security
	 * @param name as String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get currency of this security
	 * @param cur as Currency
	 */
	public Currency getCur() {
		return cur;
	}

	/**
	 * set currency of this security
	 * @param cur as Currency
	 */
	public void setCur(Currency cur) {
		this.cur = cur;
	}
}
