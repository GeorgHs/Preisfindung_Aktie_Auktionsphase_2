package com.georghs.vertx.pricing.components;

public class Stock {
	private String ticker;
	private String stockname;
	private Currency cur;
	public Stock() {
		//default constructor
	}

	/**
	 * @param: ticker - als String-Bezeichner im Ticker-Format
	 * @param: stockname - Full Company Name
	 * @param: lastPrice - Letzter Preis des Stocks
	 */
	public Stock(String ticker, String stockname, Currency cur) {
		super();
		this.ticker = ticker;
		this.stockname = stockname;
		this.cur = cur;
	}

	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public Currency getCur() {
		return cur;
	}

	public void setCur(Currency cur) {
		this.cur = cur;
	}

}
