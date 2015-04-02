package com.tmoreno.katapotter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookStack {

	private Map<Integer, Integer> stack;

	public BookStack() {
		stack = new HashMap<>();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public void addBooks(int[] books) {
		for (int book : books) {
			addCopy(book);
		}
	}

	private void addCopy(int book) {
		Integer numBooks = stack.get(book);

		if (numBooks == null) {
			stack.put(book, 1);
		} else {
			stack.put(book, numBooks.intValue() + 1);
		}
	}

	public void removeOneCopyOfEachBook(List<Integer> books) {
		for (int book : books) {
			if (stack.get(book) == 1) {
				stack.remove(book);
			} else {
				stack.put(book, stack.get(book) - 1);
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
		return stack.keySet();
	}

	private Integer getNumberOfCopies(Integer book) {
		return stack.get(book);
	}
}
