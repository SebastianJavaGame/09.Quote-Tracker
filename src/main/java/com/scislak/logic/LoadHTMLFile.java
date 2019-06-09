package com.scislak.logic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.scislak.logic.StockSymbol.Symbols;

public class LoadHTMLFile {
	private static final String BASE_URL = "https://stooq.pl/q/?s=";
	
	private StringBuilder page;
	private List<String> spanList;
	private Symbols symbol;
	
	public LoadHTMLFile(Symbols symbol) {
		this.symbol = symbol;
		loadPage();
		cleanHtml(page.toString());
	}
	
	public void cleanHtml(String html) {
		spanList = new ArrayList<>();
		int startTagIndex = 0;	
		boolean opened = false;
		
		for(int n = 0; n < page.length()-10; n++) {
			if(page.charAt(n) == '<') {
				if(page.substring(n+1, n+11).equals("span id=aq")) {
					startTagIndex = n;
					opened = true;
				}
				else if(opened && page.substring(n +1, n+6).equals("/span")) {
					spanList.add(page.substring(startTagIndex, n+7));
					opened = false;
				}
			}
		}
	}
	
	private void loadPage() {
		try {
			URL url = new URL(BASE_URL + StockSymbol.getSymbol(symbol));
			URLConnection con = url.openConnection();
		
			Reader r = new InputStreamReader(con.getInputStream(), "UTF-8");
			page = new StringBuilder();
			
			while (true) {
			  int ch = r.read();
			  if (ch < 0)
			    break;
			  page.append((char) ch);
			}
		} catch (IOException e) {}
	}
	
	public void filterThisSymbol() {
		spanList.stream().filter(s->s.substring(12, 18).equals(StockSymbol.getSymbol(symbol))).forEach(System.out::println);
	}
	
	public void showActualSpan() {
		spanList.forEach(System.out::println);
	}
}