package com.tmoreno.katapotter.strategy;

import java.util.List;
import java.util.Map;

public interface GroupingStrategy {

	List<Integer> getGroupedBooks(Map<Integer, Integer> copies);
}
