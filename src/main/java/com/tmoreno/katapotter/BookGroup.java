package com.tmoreno.katapotter;

import java.util.ArrayList;
import java.util.List;

public class BookGroup {
	private List<List<Integer>> groups;

	public BookGroup() {
		groups = new ArrayList<>();
	}

	public void newGroup(List<Integer> books) {
		groups.add(books);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		int numberOfGroupsWithNBooks = 0;

		for (Discount discount : Discount.values()) {
			numberOfGroupsWithNBooks = numberOfGroupsWithNBooks(discount
					.getNumberBooks());

			if (numberOfGroupsWithNBooks > 0) {
				sb.append(discount.toString(groups.size(),
						numberOfGroupsWithNBooks));
				sb.append(" + ");
			}
		}

		sb.setLength(sb.length() - 3);

		return sb.toString();
	}

	private int numberOfGroupsWithNBooks(int n) {
		int numberOfGroupsWithNBooks = 0;

		for (List<Integer> books : groups) {
			if (books.size() == n) {
				numberOfGroupsWithNBooks++;
			}
		}

		return numberOfGroupsWithNBooks;
	}
}
