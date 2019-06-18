package com.scislak.logic;

import java.util.ArrayList;
import java.util.List;

public class DataBaseOfCurrencies {
	private static List<Currency> currencies = new ArrayList<>();
	
	public static void addCurrency(Currency currency) {
		currencies.add(currency);
	}
	
	public static Currency getCurrency(int index) {
		return currencies.get(index);
	}
	
	public static List<Currency> getAll(){
		return currencies;
	}
	
	public static void showAllInformation() {
		for(Currency c: getAll()) {
			System.out.println(c.toString());
		}
	}
}
