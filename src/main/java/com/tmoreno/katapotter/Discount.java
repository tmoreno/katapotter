package com.tmoreno.katapotter;

public enum Discount {
	NO_DISCOUNT(1, "") {
		@Override
		public String toString(int numberOfGroups,
				int numberOfGroupsWithSameBooks) {
			if (numberOfGroupsWithSameBooks == 1) {
				return BASE_PRIZE;
			} else {
				return BASE_PRIZE + " * " + numberOfGroupsWithSameBooks;
			}
		}
	},
	DISCOUNT_25_PERCENT(5, "0.75"), DISCOUNT_20_PERCENT(4, "0.8"), DISCOUNT_10_PERCENT(
			3, "0.9"), DISCOUNT_5_PERCENT(2, "0.95");

	public static final String BASE_PRIZE = "8";

	private int numberBooks;
	private String discount;

	private Discount(int numberBooks, String discount) {
		this.numberBooks = numberBooks;
		this.discount = discount;
	}

	public int getNumberBooks() {
		return numberBooks;
	}

	public String toString(int numberOfGroups, int numberOfGroupsWithSameBooks) {
		return leftBracket(numberOfGroups, numberOfGroupsWithSameBooks)
				+ BASE_PRIZE + " * " + numberBooks + " * " + discount
				+ rightBracket(numberOfGroups);
	}

	private String leftBracket(int numberOfGroups,
			int numberOfGroupsWithSameBooks) {
		if (numberOfGroups > 1) {
			if (numberOfGroupsWithSameBooks > 1) {
				return numberOfGroupsWithSameBooks + " * (";
			} else {
				return "(";
			}
		} else {
			return "";
		}
	}

	private String rightBracket(int numberOfGroups) {
		if (numberOfGroups > 1) {
			return ")";
		} else {
			return "";
		}
	}
}
