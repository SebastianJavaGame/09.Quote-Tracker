package com.scislak.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.scislak.logic.StockSymbol.Symbols;

public class LoadHTMLFileTest {

	private LoadHTMLFile page;
	
	@Before
	public void init() {
		page = new LoadHTMLFile(Symbols.EURPLN);
	}
	
	@Test
	public void notNull() {
		assertNotNull(page);
	}
	
	@Test
	public void getSymbol() {
		assertEquals("usdpln", StockSymbol.getSymbol(Symbols.USDPLN));
	}
	
	@Test
	public void showAllAttributesWithEqualsId() {
		
	}

}
