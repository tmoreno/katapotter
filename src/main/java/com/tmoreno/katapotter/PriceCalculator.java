package com.tmoreno.katapotter;

public class PriceCalculator {

	private static final String BASE_PRICE = "8";
	private static final String DISCOUNT_5_PERCENT = "0.95";

	public String calculate(int[] basket) {
		if (basket.length == 0) {
			return "0";
		} else if (basket.length == 1) {
			return BASE_PRICE;
		} else {
			String result = BASE_PRICE + " * " + basket.length;

			if (basket[0] != basket[1]) {
				result += " * " + DISCOUNT_5_PERCENT;
			}

			return result;
		}
	}

}