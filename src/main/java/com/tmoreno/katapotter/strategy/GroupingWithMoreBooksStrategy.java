package com.tmoreno.katapotter.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupingWithMoreBooksStrategy implements GroupingStrategy {

	@Override
	public List<Integer> getGroupedBooks(Map<Integer, Integer> copies) {
		int maxCopies = 1;
		List<Integer> books = new ArrayList<>();

		for (int book : copies.keySet()) {
			int numberOfCopies = copies.get(book);

			if (numberOfCopies == maxCopies) {
				books.add(book);
			} else if (numberOfCopies > maxCopies) {
				books = new ArrayList<>();
				books.add(book);
				maxCopies = numberOfCopies;
			}
		}

		return books;
	}
}
