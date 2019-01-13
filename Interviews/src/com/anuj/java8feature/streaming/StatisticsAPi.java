package com.anuj.java8feature.streaming;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class StatisticsAPi {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(22, 33, 43, 11, 9);
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println(stats.getMax());
		System.out.println(stats.getAverage());
		System.out.println(stats.getCount());
	}

}
