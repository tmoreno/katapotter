package com.tmoreno.katapotter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tmoreno.katapotter.strategy.GroupingStrategy;

public class BookCopies {

	private Map<Integer, Integer> copies;
	private GroupingStrategy groupStrategy;

	public BookCopies(GroupingStrategy groupStrategy) {
		this.groupStrategy = groupStrategy;

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
		}
		else {
			copies.put(book, numBooks.intValue() + 1);
		}
	}

	public void removeOneCopyOfEachBook(List<Integer> books) {
		for (int book : books) {
			if (copies.get(book) == 1) {
				copies.remove(book);
			}
			else {
				copies.put(book, copies.get(book) - 1);
			}
		}
	}

	public List<Integer> getBooksWithMaxCopies() {
		return groupStrategy.getGroupedBooks(copies);
	}
}
