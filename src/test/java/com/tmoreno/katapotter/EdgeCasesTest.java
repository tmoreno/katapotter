package com.tmoreno.katapotter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EdgeCasesTest {

	private PriceCalculator calculator;
	private int[] basket;

	@Before
	public void setUp() {
		calculator = new PriceCalculator();
	}

	@Test
	public void twoGroupsOf4BooksIsBetter() {
		basket = new int[] { 0, 0, 1, 1, 2, 2, 3, 4 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("2 * (8 * 4 * 0.8)", price);
	}

}
