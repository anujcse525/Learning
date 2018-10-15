package com.anuj.hackerrank;

import java.util.Scanner;

public class NewYearChaos {

	static void minimumBribes(int[] q) {
		int bribes = 0;
		System.out.println(q.length);
		for (int i = 0; i < q.length; i++) {
			int diff = q[i] - (i + 1);
			if (diff > 2) {
				System.out.println("Too Chaotic");
				return;
			}
			for (int j = Math.max(0, q[i] - 2); j < i; j++)
				if (q[j] > q[i])
					bribes++;
		}
		System.out.println(bribes);
	}

	static void countBribes(int[] inputLine) {
		long start = System.currentTimeMillis();
		int n = inputLine.length;
		int[] outputFrequencyDistribution = new int[n + 1];
		boolean chaos = false;
		boolean finished = false;
		int count = 0;
		while (!finished) {
			finished = true;
			for (int a = 0; a < n - 1; a++) {
				if (inputLine[a] > inputLine[a + 1]) {
					outputFrequencyDistribution[inputLine[a]]++;
					if (outputFrequencyDistribution[inputLine[a]] > 2) {
						finished = true;
						chaos = true; // if it's too chaotic, break out
						break;
					}
					count++;
					int temp = inputLine[a];
					inputLine[a] = inputLine[a + 1];
					inputLine[a + 1] = temp;
					finished = false;
				}
			}
		}
		if (chaos) {
			System.out.println("Too chaotic");
		} else {
			System.out.println(count);
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
			countBribes(q);
		}

		scanner.close();
	}

}
