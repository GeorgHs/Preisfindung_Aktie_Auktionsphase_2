package com.georghs.vertx.pricing.participants;

public class MarketMaker extends MarketParticipant {

	private String nameOfBank;
	private String bankCode;

	public MarketMaker(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public String getNameOfBank() {
		return nameOfBank;
	}

	public void setNameOfBank(String nameOfBank) {
		this.nameOfBank = nameOfBank;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

}
