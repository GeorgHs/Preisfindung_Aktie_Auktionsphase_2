package com.georghs.vertx.pricing.participants;

public class MarketMaker extends MarketParticipant {

	private String bankCode;

	/**
	The MarketMaker, usually a financial institution is payed to provide the market with liquidity
	@param id
	@param name What is the official name fo the financial institution, for example: Bank of America Corporation
	@param bankCode bankCode der Bank
	*/
	public MarketMaker(int id, String name,  String bankCode) {
		super(id, name);
		// TODO Auto-generated constructor stub
		this.bankCode = bankCode;
	}


	/**
	Market Maker's bank code
	@return bankCode
	*/
	public String getBankCode() {
		return bankCode;
	}

	/**
	Market Maker sets bankCode
	@param bankCode
	*/
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

}
