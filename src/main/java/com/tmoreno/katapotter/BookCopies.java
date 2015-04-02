package com.tmoreno.katapotter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookCopies {

	private Map<Integer, Integer> copies;

	public BookCopies() {
		copies = new HashMap<>();
	}

	public boolean isEmpty() {
		return copies.isEmpty();
	}

	public void addCopies(int[] books) {
		for (int book : books) {
			addCopy(book);
		}
	}

	private void addCopy(int book) {
		Integer numBooks = copies.get(book);

		if (numBooks == null) {
			copies.put(book, 1);
		} else {
			copies.put(book, numBooks.intValue() + 1);
		}
	}

	public void removeOneCopyOfEachBook(List<Integer> books) {
		for (int book : books) {
			if (copies.get(book) == 1) {
				copies.remove(book);
			} else {
				copies.put(book, copies.get(book) - 1);
			}
		}
	}

	public List<Integer> getBooksWithMaxCopies() {
		int maxCopies = 1;
		List<Integer> books = new ArrayList<>();

		for (int book : getDifferentBooks()) {
			int numberOfCopies = getNumberOfCopies(book);

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

	private Set<Integer> getDifferentBooks() {
		return copies.keySet();
	}

	private Integer getNumberOfCopies(Integer book) {
		return copies.get(book);
	}
}
