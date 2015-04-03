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

	@Test
	public void twoGroupsOf4BooksAnd3GroupsOf5BooksIsBetter() {
		basket = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8)", price);
	}

}
