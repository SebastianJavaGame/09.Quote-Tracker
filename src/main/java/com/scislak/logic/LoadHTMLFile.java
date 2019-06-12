package com.scislak.logic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class LoadHTMLFile {
	private static StringBuilder page;
	private static List<String> spanList = new ArrayList<>();
	
	public static void refreshPage() {
		getDataFromPage();
	}
	
	public static void getDataFromPage() {
		try {
			spanList.clear();
			loadPage();
			cleanHtml(page.toString());
		}catch(NullPointerException e) {
			System.out.println("No connection");
		}
	}
	
	private static void cleanHtml(String html) {
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
	
	private static void loadPage() {
		try {
			URL url = new URL("https://stooq.pl/t/?i=558");
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
	
	public static List<String> getListItems(){
		return spanList;
	}
}