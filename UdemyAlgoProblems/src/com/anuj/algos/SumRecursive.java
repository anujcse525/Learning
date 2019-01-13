package com.anuj.algos;

public class SumRecursive {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(sumRecursive(100000));
		System.out.println("Recursive : " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		System.out.println(sumIterative(100000));
		System.out.println("Iterative : " + (System.currentTimeMillis() - start));
	}

	public static int sumRecursive(int n) {
		
		if (n == 1) {
			return 1;
		}
		int sum = n + sumRecursive(n - 1);
		
		return sum;
	}

	public static int sumIterative(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
}
