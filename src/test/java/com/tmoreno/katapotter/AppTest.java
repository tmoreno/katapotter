package com.tmoreno.katapotter;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

	@Test
	public void givenEmptyBagPriceIs0() {
		PriceCalculator calculator = new PriceCalculator();
		String price = calculator.calculate(new int[] {});
		Assert.assertEquals("0", price);
	}
}
