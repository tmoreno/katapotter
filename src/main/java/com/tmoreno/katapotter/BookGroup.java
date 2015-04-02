package com.tmoreno.katapotter;

import java.util.ArrayList;
import java.util.List;

public class BookGroup {

	private static final String DISCOUNT_5_PERCENT = "0.95";
	private static final String DISCOUNT_10_PERCENT = "0.9";
	private static final String DISCOUNT_20_PERCENT = "0.8";
	private static final String DISCOUNT_25_PERCENT = "0.75";

	private List<List<Integer>> groups;

	public BookGroup() {
		groups = new ArrayList<>();
	}

	public void newGroup(List<Integer> books) {
		groups.add(books);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		int numberOfGroups = 0;

		for (int i = 1; i <= 5; i++) {
			numberOfGroups = numberOfGroupsWithNBooks(i);

			if (numberOfGroups > 0) {
				switch (i) {
				case 1:
					if (numberOfGroups == 1) {
						sb.append("8");
					} else {
						sb.append("8 * " + numberOfGroups);
					}

					break;

				case 2:
					sb.append(leftBracket(numberOfGroups));

					sb.append("8 * 2 * " + DISCOUNT_5_PERCENT);

					sb.append(rightBracket());

					break;

				case 3:
					sb.append(leftBracket(numberOfGroups));

					sb.append("8 * 3 * " + DISCOUNT_10_PERCENT);

					sb.append(rightBracket());

					break;

				case 4:
					sb.append(leftBracket(numberOfGroups));

					sb.append("8 * 4 * " + DISCOUNT_20_PERCENT);

					sb.append(rightBracket());

					break;

				case 5:
					sb.append(leftBracket(numberOfGroups));

					sb.append("8 * 5 * " + DISCOUNT_25_PERCENT);

					sb.append(rightBracket());

					break;
				}

				sb.append(" + ");
			}
		}

		sb.setLength(sb.length() - 3);

		return sb.toString();
	}

	private String leftBracket(int numberOfGroups) {
		if (groups.size() > 1) {
			if (numberOfGroups > 1) {
				return numberOfGroups + " * (";
			} else {
				return "(";
			}
		} else {
			return "";
		}
	}

	private String rightBracket() {
		if (groups.size() > 1) {
			return ")";
		} else {
			return "";
		}
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
