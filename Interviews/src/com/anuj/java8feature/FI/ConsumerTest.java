package com.anuj.java8feature.FI;

import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		Consumer<String> cs = s -> System.out.println(s);
		cs.accept("Hello");
	}

}
