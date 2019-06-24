package com.example.scislak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.scislak.logic.Currency;
import com.scislak.logic.DataBaseOfCurrencyPrice;
import com.scislak.logic.RefreshingData;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	public final static int SECONDS_WAIT = 20;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Application app = new Application();
		app.practiseTest();
	}
	
	public void practiseTest() {
		DataBaseOfCurrencyPrice.addCurrency(new Currency("EURUSD"));
		DataBaseOfCurrencyPrice.addCurrency(new Currency("USDPLN"));
		DataBaseOfCurrencyPrice.addCurrency(new Currency("AUDSD"));
		DataBaseOfCurrencyPrice.addCurrency(new Currency("EURPLN"));
		DataBaseOfCurrencyPrice.addCurrency(new Currency("AUDPLN"));
		DataBaseOfCurrencyPrice.addCurrency(new Currency("JPYPLN"));
		RefreshingData.init();
		DataBaseOfCurrencyPrice.showAllInformation();
		
		try {
			for(int i = 0; i < SECONDS_WAIT; i++) {
				System.out.println("Time to wait: " + (SECONDS_WAIT -i));
				Thread.sleep(1000);
			}
			System.out.println("Reading data...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		RefreshingData.refreshData();
		DataBaseOfCurrencyPrice.showAllInformation();
	}

}
