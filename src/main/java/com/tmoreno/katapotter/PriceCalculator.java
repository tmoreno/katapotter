package com.tmoreno.katapotter;

public class PriceCalculator {

	private static final String BASE_PRICE = "8";
	private static final String DISCOUNT_5_PERCENT = "0.95";
	private static final String DISCOUNT_10_PERCENT = "0.9";

	public String calculate(int[] basket) {
		if (basket.length == 0) {
			return "0";
		} else if (basket.length == 1) {
			return BASE_PRICE;
		} else {
			String result = BASE_PRICE + " * " + basket.length;

			int differentBooks = 0;
			for (int i = 1; i < basket.length; i++) {
				if (basket[i] != basket[i - 1]) {
					differentBooks++;
				}
			}

			switch (differentBooks) {
			case 1:
				result += " * " + DISCOUNT_5_PERCENT;
				break;

			case 2:
				result += " * " + DISCOUNT_10_PERCENT;
				break;

			default:
				break;
			}

			return result;
		}
	}

}