package com.scislak.logic;

import java.util.List;

public class RefreshingData {
	private static RefreshingData instance = null;
	
	private RefreshingData() {}
	
	public static RefreshingData init() {
		if(instance == null) {
			instance = new RefreshingData();
			LoadHTMLFile.refreshPage();
			createCurrency(LoadHTMLFile.getListItems());
		}
		return instance;
	}
	
	public static void refreshData() {
		LoadHTMLFile.refreshPage();
		refreshPrice(LoadHTMLFile.getListItems());
	}
	
	private static void createCurrency(List<String> itemList) {
		for(int i = 0; i < itemList.size(); i+=4) {
			Currency curr = new Currency(itemList.get(i).toString().substring(12, 18));
			DataBaseOfCurrencies.addCurrency(curr);
		}
		refreshPrice(itemList);
	}
	
	private static void refreshPrice(List<String> itemList) {
		int j = 0;
		for(int i = 0; i < itemList.size(); i+=4) {
			float price = readPriceFromLine(itemList.get(i));
			DataBaseOfCurrencies.getCurrency(j).changePrice(price);
			j++;
		}
	}
	
	private static float readPriceFromLine(String line) {
		char[] priceChars = line.toCharArray();
		int startIndex = 0;
		
		for(int i = 18; i < priceChars.length; i++) {
			if(priceChars[i] == '>') {
				startIndex = i+1;
				
				for(int j = i; j < priceChars.length; j++) {
					if(priceChars[j] == '<')
						return Float.parseFloat(line.substring(startIndex, j-1));
				}
			}
		}
		return 0.0f;
	}
}
