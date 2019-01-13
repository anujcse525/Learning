package com.anuj.java8feature.FI;

import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		Predicate<Integer> pd =  I-> I%2==0;
		Predicate<Integer> pd1 =  I-> I>10;
		System.out.println(pd.and(pd1).test(8));
	}

}
