package com.anuj.eggproblem;

public class EggProblem {

	public static int calculateAttempts(int eggs, int floors) {

		int T[][] = new int[eggs + 1][floors + 1];
		int c = 0;
		for (int i = 0; i <= floors; i++) {
			T[1][i] = i;
		}

		for (int e = 2; e <= eggs; e++) {
			for (int f = 1; f <= floors; f++) {
				T[e][f] = Integer.MAX_VALUE;
				for (int k = 1; k <= f; k++) {
					c = 1 + Math.max(T[e - 1][k - 1], T[e][f - k]);
					if (c < T[e][f]) {
						T[e][f] = c;
					}
				}
			}
		}
		return T[eggs][floors];
	}

	public static int calculateRecursive(int eggs, int floors) {
		if (eggs == 1) {
			return floors;
		}
		if (floors == 0) {
			return 0;
		}
		int min = 1000;
		for (int i = 1; i <= floors; i++) {
			int val = 1 + Math.max(calculateRecursive(eggs - 1, i - 1), calculateRecursive(eggs, floors - i));
			if (val < min) {
				min = val;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		System.out.println(calculateAttempts(2, 10));
		System.out.println(calculateRecursive(2, 10));
	}

}