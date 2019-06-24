package com.scislak.logic;

import java.util.ArrayList;
import java.util.List;

public class DataBaseOfCurrencyPrice {
	private static List<Currency> currencies = new ArrayList<>();
	
	public static void addCurrency(Currency currency) {
		if(!currencies.contains(currency))
			currencies.add(currency);
	}
	
	public static Currency getCurrency(int index) {
		return currencies.get(index);
	}
	
	public static void removeContain(Currency currency) {
		currencies.remove(currency);
	}
	
	public static List<Currency> getAll(){
		return currencies;
	}
	
	public static void showAllInformation() {
		for(Currency c: getAll()) {
			System.out.println(c.toString());
		}
	}
	
	public static int getSize() {
		return currencies.size();
	}
}
