package com.tmoreno.katapotter;

public class PriceCalculator {

	private static final String BASE_PRICE = "8";
	private static final String DISCOUNT_5_PERCENT = "0.95";
	private static final String DISCOUNT_10_PERCENT = "0.9";
	private static final String DISCOUNT_20_PERCENT = "0.8";
	private static final String DISCOUNT_25_PERCENT = "0.75";

	public String calculate(int[] basket) {
		if (basket.length == 0) {
			return "0";
		} else if (basket.length == 1) {
			return BASE_PRICE;
		} else {
			int booksWithDiscount = 1;
			int booksWithoutDiscount = 1;

			int differentBooks = 0;
			for (int i = 1; i < basket.length; i++) {
				if (basket[i] != basket[i - 1]) {
					differentBooks++;
					booksWithDiscount++;
					booksWithoutDiscount--;
				} else {
					booksWithoutDiscount++;
				}
			}

			return result(booksWithDiscount, booksWithoutDiscount,
					differentBooks);
		}
	}

	private String result(int booksWithDiscount, int booksWithoutDiscount,
			int differentBooks) {

		String result = "";

		if (booksWithoutDiscount == 1) {
			result += BASE_PRICE;
		} else if (booksWithoutDiscount > 1) {
			result += BASE_PRICE + " * " + booksWithoutDiscount;
		}

		if (booksWithDiscount > 1) {
			if (booksWithoutDiscount > 0) {
				result += " + (";
			}

			result += BASE_PRICE + " * " + booksWithDiscount;
			switch (differentBooks) {
			case 1:
				result += " * " + DISCOUNT_5_PERCENT;
				break;

			case 2:
				result += " * " + DISCOUNT_10_PERCENT;
				break;

			case 3:
				result += " * " + DISCOUNT_20_PERCENT;
				break;

			case 4:
				result += " * " + DISCOUNT_25_PERCENT;
				break;

			default:
				break;
			}

			if (booksWithoutDiscount > 0) {
				result += ")";
			}
		}

		return result;
	}
}