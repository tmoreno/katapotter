package com.tmoreno.katapotter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BaseTest {

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

	@Test
	public void givenBasketWithBook1PriceIs8() {
		basket = new int[] { 1 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("8", price);
	}

	@Test
	public void givenBasketWithBook2PriceIs8() {
		basket = new int[] { 2 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("8", price);
	}

	@Test
	public void givenBasketWithBook3PriceIs8() {
		basket = new int[] { 3 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("8", price);
	}

	@Test
	public void givenBasketWithBook4PriceIs8() {
		basket = new int[] { 4 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("8", price);
	}

	@Test
	public void givenBasketWith2Books0PriceIs16() {
		basket = new int[] { 0, 0 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("8 * 2", price);
	}

	@Test
	public void givenBasketWith3Books1PriceIs24() {
		basket = new int[] { 1, 1, 1 };

		String price = calculator.calculate(basket);

		Assert.assertEquals("8 * 3", price);
	}
}
