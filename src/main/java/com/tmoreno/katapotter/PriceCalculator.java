package com.tmoreno.katapotter;

import java.util.ArrayList;
import java.util.List;

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
			BookStack bookStack = new BookStack();
			bookStack.addBooks(basket);

			List<Integer> books;
			List<List<Integer>> groups = new ArrayList<>();
			while (!bookStack.isEmpty()) {
				books = bookStack.getBooksWithMaxCopies();

				bookStack.removeOneCopyOfEachBook(books);

				groups.add(books);
			}

			return toString(groups);
		}
	}

	private String toString(List<List<Integer>> groups) {
		StringBuilder sb = new StringBuilder();
		int numRepeats = 0;

		for (int i = 1; i <= 5; i++) {
			numRepeats = 0;

			for (List<Integer> group : groups) {
				if (group.size() == i) {
					numRepeats++;
				}
			}

			if (numRepeats > 0) {
				switch (i) {
				case 1:
					if (numRepeats == 1) {
						sb.append("8");
					} else {
						sb.append("8 * " + numRepeats);
					}

					break;

				case 2:
					if (groups.size() > 1) {
						if (numRepeats > 1) {
							sb.append(numRepeats + " * (");
						} else {
							sb.append("(");
						}
					}

					sb.append("8 * 2 * " + DISCOUNT_5_PERCENT);

					if (groups.size() > 1) {
						sb.append(")");
					}

					break;

				case 3:
					if (groups.size() > 1) {
						if (numRepeats > 1) {
							sb.append(numRepeats + " * (");
						} else {
							sb.append("(");
						}
					}

					sb.append("8 * 3 * " + DISCOUNT_10_PERCENT);

					if (groups.size() > 1) {
						sb.append(")");
					}

					break;

				case 4:
					if (groups.size() > 1) {
						if (numRepeats > 1) {
							sb.append(numRepeats + " * (");
						} else {
							sb.append("(");
						}
					}

					sb.append("8 * 4 * " + DISCOUNT_20_PERCENT);

					if (groups.size() > 1) {
						sb.append(")");
					}

					break;

				case 5:
					if (groups.size() > 1) {
						if (numRepeats > 1) {
							sb.append(numRepeats + " * (");
						} else {
							sb.append("(");
						}
					}

					sb.append("8 * 5 * " + DISCOUNT_25_PERCENT);

					if (groups.size() > 1) {
						sb.append(")");
					}

					break;
				}

				sb.append(" + ");
			}
		}

		sb.setLength(sb.length() - 3);

		return sb.toString();
	}
}