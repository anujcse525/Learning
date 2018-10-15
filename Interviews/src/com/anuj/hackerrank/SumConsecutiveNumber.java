package com.anuj.hackerrank;

/*
Problem Statement : 
  Utility method to compute number of ways
  in which N can be represented as sum of
  consecutive number
*/

/* The idea is to represent N as a sequence of length L+1 as:
N = a + (a+1) + (a+2) + .. + (a+L)
=> N = (L+1)*a + (L*(L+1))/2
=> a = (N- L*(L+1)/2)/(L+1)
We substitute the values of L starting from 1 till L*(L+1)/2 < N
If we get 'a' as a natural number then the solution should be counted.
 */
public class SumConsecutiveNumber {
	// Utility method to compute number of ways
	// in which N can be represented as sum of
	// consecutive number
	static int countConsecutive(int N) {
		// constraint on values of L gives us the
		// time Complexity as O(N^0.5)
		int count = 0;
		for (int L = 1; L * (L + 1) < 2 * N; L++) {
			float a = (float) ((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
			if (a - (int) a == 0.0)
				count++;
		}
		return count;
	}

	static int count(int n) {
		int count = 0;

		for (int i = 1; i <= Math.sqrt(n); i++) {
			float calc = (float) ((1.0) * n / i + i / 2.0 + 1.0 / 2.0);
			if (calc - (int) calc == 0.0) {
				count++;
			}
		}
		return count;
	}

	// Driver code to test above function
	public static void main(String[] args) {
		int N = 15;
		System.out.println(count(5));
		System.out.println(countConsecutive(5));
		N = 10;
		System.out.println(count(88));
	}
}
