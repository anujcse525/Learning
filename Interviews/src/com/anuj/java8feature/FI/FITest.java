package com.anuj.java8feature.FI;

public class FITest {

	public static void main(String[] args) {
		FIInterface fii = (a,b) -> a + b;
		System.out.println(fii.add(34, 45));

	}

}
