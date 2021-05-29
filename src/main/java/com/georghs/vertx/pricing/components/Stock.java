package com.georghs.vertx.pricing.components;

public class Stock extends AbstractSecurity {
	/**
	 * Stock is an asset which is a security and trades as equity of a company
	 * @param: ticker - ticker of that security
	 * @param: name - what's the name of the security
	 * @param: cur - What's the national currency that security is being traded in
	 */
	public Stock(String ticker, String stockname, Currency cur) {
		super(ticker, stockname, cur);
		// TODO Auto-generated constructor stub
	}


}
