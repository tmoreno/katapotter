package com.tmoreno.katapotter;

import java.util.List;

public class PriceCalculator {

	private static final String BASE_PRICE = "8";

	public String calculate(int[] basket) {
		if (basket.length == 0) {
			return "0";
		} else if (basket.length == 1) {
			return BASE_PRICE;
		} else {
			BookCopies bookCopies = new BookCopies();
			bookCopies.addCopies(basket);

			List<Integer> books;
			BookGroup groups = new BookGroup();
			while (!bookCopies.isEmpty()) {
				books = bookCopies.getBooksWithMaxCopies();

				bookCopies.removeOneCopyOfEachBook(books);

				groups.newGroup(books);
			}

			return groups.toString();
		}
	}
}