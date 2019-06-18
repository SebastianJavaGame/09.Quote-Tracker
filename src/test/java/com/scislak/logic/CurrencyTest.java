package com.scislak.logic;

import static org.junit.Assert.*;
import com.scislak.logic.StockSymbol.Symbols;

import org.junit.Test;

public class CurrencyTest {
 
	@Test	
	public void percentageMinus() {
		Currency cur = new Currency(StockSymbol.getSymbol(Symbols.EURPLN));
		cur.changePrice(4.2395f);
		cur.changePrice(4.2345f);
		assertEquals(-0.0011f, cur.getChange(), .0001f);
	}
	
	@Test
	public void percentagePlus() {
		Currency cur = new Currency(StockSymbol.getSymbol(Symbols.EURPLN));
		cur.changePrice(4.2345f);
		cur.changePrice(4.2395f);
		assertEquals(0.0011f, cur.getChange(), .0001f);
	}

}
