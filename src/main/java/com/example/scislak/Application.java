package com.example.scislak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scislak.logic.DataBaseOfCurrencies;
import com.scislak.logic.RefreshingData;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Application app = new Application();
		app.go();
	}
	
	public void go() {
		RefreshingData.init();
		DataBaseOfCurrencies.showAllInformation();
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RefreshingData.refreshData();
		DataBaseOfCurrencies.showAllInformation();
	}

}
