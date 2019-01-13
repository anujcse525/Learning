package com.anuj.java8feature.FI;

import java.util.function.IntPredicate;

public class IntPredicateTest {

	public static void main(String[] args) {
		IntPredicate ip = (i) -> i%2==0;
		System.out.println(ip.test(22));

	}

}
