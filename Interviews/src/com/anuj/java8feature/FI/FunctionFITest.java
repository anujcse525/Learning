package com.anuj.java8feature.FI;

import java.util.function.Function;

public class FunctionFITest {

	public static void main(String[] args) {
		Function<String, Integer> fu = s -> s.length();
		System.out.println(fu.apply("Anuj"));

	}

}
