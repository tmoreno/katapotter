package com.tmoreno.katapotter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

	private PriceCalculator calculator;

	@Before
	public void setUp() {
		calculator = new PriceCalculator();
	}

	@Test
	public void givenEmptyBagPriceIs0() {
		String price = calculator.calculate(new int[] {});
		Assert.assertEquals("0", price);
	}

	@Test
	public void givenBagWithBook0PriceIs8() {
		String price = calculator.calculate(new int[] { 0 });
		Assert.assertEquals("8", price);
	}
}
