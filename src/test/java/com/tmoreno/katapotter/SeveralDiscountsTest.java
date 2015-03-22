package com.tmoreno.katapotter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SeveralDiscountsTest {

	private PriceCalculator calculator;
	private int[] basket;

	@Before
	public void setUp() {
		calculator = new PriceCalculator();
	}

	@Test
	public void applyOneDiscount() {
		basket = new int[] { 0, 0, 1 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("8 + (8 * 2 * 0.95)", price);
	}

	@Test
	public void applyTwoDiscounts() {
		basket = new int[] { 0, 0, 1, 1 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("2 * (8 * 2 * 0.95)", price);
	}
}
