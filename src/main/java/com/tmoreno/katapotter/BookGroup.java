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
			numberOfGroupsWithNBooks = numberOfGroupsWithNBooks(discount.getNumberBooks());

			if (numberOfGroupsWithNBooks > 0) {
				sb.append(discount.toString(groups.size(), numberOfGroupsWithNBooks));
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

	public double getPrice() {
		double price = 0;

		for (List<Integer> books : groups) {
			switch (books.size()) {
				case 1:
					price += Discount.BASE_PRIZE * books.size();
					break;

				case 2:
					price += Discount.BASE_PRIZE * books.size() * Discount.DISCOUNT_5_PERCENT.getDiscount();
					break;

				case 3:
					price += Discount.BASE_PRIZE * books.size() * Discount.DISCOUNT_10_PERCENT.getDiscount();
					break;

				case 4:
					price += Discount.BASE_PRIZE * books.size() * Discount.DISCOUNT_20_PERCENT.getDiscount();
					break;

				case 5:
					price += Discount.BASE_PRIZE * books.size() * Discount.DISCOUNT_25_PERCENT.getDiscount();
					break;

				default:
					break;
			}
		}

		return price;
	}
}
