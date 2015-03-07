package com.tmoreno.katapotter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

	private PriceCalculator calculator;
	private int[] basket;

	@Before
	public void setUp() {
		calculator = new PriceCalculator();
	}

	@Test
	public void givenEmptyBasketPriceIs0() {
		basket = new int[] {};

		String price = calculator.calculate(basket);

		Assert.assertEquals("0", price);
	}

	@Test
	public void givenBasketWithBook0PriceIs8() {
		basket = new int[] { 0 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("8", price);
	}
}
