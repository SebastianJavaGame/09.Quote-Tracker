package com.scislak.logic;

public class StockSymbol {
	public enum Symbols {USDPLN, EURPLN};
	
	public static String getSymbol(Symbols symbol) {
		return symbol.toString().toLowerCase();
	}
}
