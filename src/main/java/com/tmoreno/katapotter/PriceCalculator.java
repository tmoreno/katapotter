package com.tmoreno.katapotter;

public class PriceCalculator {

	private static final String BASE_PRICE = "8";

	public String calculate(int[] basket) {
		if (basket.length == 0) {
			return "0";
		} else if (basket.length == 1) {
			return BASE_PRICE;
		} else {
			return BASE_PRICE + " * " + basket.length;
		}
	}

}