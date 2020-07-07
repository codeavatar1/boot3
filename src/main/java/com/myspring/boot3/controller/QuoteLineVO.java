package com.myspring.boot3.controller;
import java.math.BigDecimal;

public class QuoteLineVO {
	public BigDecimal getHigh() {
		return High;
	}
	public void setHigh(BigDecimal high) {
		High = high;
	}
	public BigDecimal getLow() {
		return Low;
	}
	public void setLow(BigDecimal low) {
		Low = low;
	}
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal price) {
		Price = price;
	}
	public String getLastTradeTime() {
		return LastTradeTime;
	}
	public void setLastTradeTime(String lastTradeTime) {
		LastTradeTime = lastTradeTime;
	}
	private BigDecimal High;
	private BigDecimal Low;
	private BigDecimal Price;
	private String LastTradeTime;

	

}
