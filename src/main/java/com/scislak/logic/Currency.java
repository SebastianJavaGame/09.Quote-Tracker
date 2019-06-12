package com.scislak.logic;

public class Currency {
	private String symbol;
	private float price;
	private float change;
	
	public Currency(String symbol) {
		this.symbol = symbol;
	}
	
	public void changePrice(float actualPrice) {
		calculatePercentageChange(actualPrice);
		this.price = actualPrice;
	}
	
	private void calculatePercentageChange(float actualPrice) {
		float difference = actualPrice - this.price;
		this.change = difference / this.price;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public float getPrice() {
		return price;
	}
	public String getChange() {
		return String.format("%.5f%n", change);
	}
	
	public String toString() {
		return getSymbol() + " " + getPrice() + " " + getChange();
	}
}
