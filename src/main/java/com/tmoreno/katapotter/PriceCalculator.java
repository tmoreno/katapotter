package com.tmoreno.katapotter;

import java.util.List;

import com.tmoreno.katapotter.strategy.GroupingStrategy;
import com.tmoreno.katapotter.strategy.GroupingWithMoreBooksStrategy;
import com.tmoreno.katapotter.strategy.GroupingWithMoreGroupsStrategy;

public class PriceCalculator {

	public String calculate(int[] basket) {
		if (basket.length == 0) {
			return "0";
		}
		else if (basket.length == 1) {
			return Discount.BASE_PRIZE + "";
		}
		else {
			BookGroup groupsWithMoreBooksStrategy = groupByStrategy(basket, new GroupingWithMoreBooksStrategy());

			BookGroup groupsWithMoreGroupsStrategy = groupByStrategy(basket, new GroupingWithMoreGroupsStrategy());

			if (groupsWithMoreBooksStrategy.getPrice() < groupsWithMoreGroupsStrategy.getPrice()) {
				return groupsWithMoreBooksStrategy.toString();
			}
			else {
				return groupsWithMoreGroupsStrategy.toString();
			}
		}
	}

	private BookGroup groupByStrategy(int[] basket, GroupingStrategy groupStrategy) {
		BookCopies bookCopies = new BookCopies(groupStrategy);
		bookCopies.addCopies(basket);

		List<Integer> books;
		BookGroup groups = new BookGroup();

		while (!bookCopies.isEmpty()) {
			books = bookCopies.getBooksWithMaxCopies();

			bookCopies.removeOneCopyOfEachBook(books);

			groups.newGroup(books);
		}

		return groups;
	}
}