package com.anuj.java8feature.FI;

@FunctionalInterface
public interface FIInterface {

	public int add(int a, int b);
	public static int subs(int a, int b){
		return 0;
	}
	
	default int mult(int a, int b){
		return 0;
	}
}
