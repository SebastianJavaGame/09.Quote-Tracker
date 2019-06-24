package com.scislak.logic;

public class RefreshingData {
	private static RefreshingData instance = null;
	private static LoadData loadData;
	
	private RefreshingData() {}
	
	public static RefreshingData init() {
		if(instance == null) {
			instance = new RefreshingData();
			loadData = new LoadCSVData();
			
			refreshData();
		}
		return instance;
	}
	
	public static void refreshData() {
		loadData.createCurrency();
	}
}
