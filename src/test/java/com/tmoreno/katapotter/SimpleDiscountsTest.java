package com.tmoreno.katapotter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleDiscountsTest {

	private PriceCalculator calculator;
	private int[] basket;

	@Before
	public void setUp() {
		calculator = new PriceCalculator();
	}

	@Test
	public void givenBasketWith0and1BooksApply5PercentDiscount() {
		basket = new int[] { 0, 1 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("8 * 2 * 0.95", price);
	}
}
