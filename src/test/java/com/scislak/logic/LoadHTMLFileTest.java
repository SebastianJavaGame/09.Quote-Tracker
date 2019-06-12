package com.scislak.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.example.scislak.Application;
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
	public void noConnection() {
		boolean isNotNull = false;
		LoadHTMLFile file;
		if(isNotNull)
			file = new LoadHTMLFile(Symbols.USDPLN);
		else
			file = null;
		
		assertNull(file);
	}
	
	@Test
	public void getSymbol() {
		assertEquals("usdpln", StockSymbol.getSymbol(Symbols.USDPLN));
	}
}
