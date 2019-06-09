package com.example.scislak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scislak.logic.LoadHTMLFile;
import com.scislak.logic.StockSymbol.Symbols;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		LoadHTMLFile file = new LoadHTMLFile(Symbols.USDPLN);
		file.showActualSpan();
		System.out.println();
		file.filterThisSymbol();
	}

}
