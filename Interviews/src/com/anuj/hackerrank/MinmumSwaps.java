package com.anuj.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinmumSwaps {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = minimumSwaps(arr);
		System.out.println(res);
		// bufferedWriter.write(String.valueOf(res));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}

	private static int minimumSwaps(int[] arr) {
		int counts = 0;
		int i = 0;
		if (arr == null || arr.length == 0) {
			return 0;
		}
		while (i < arr.length) {
			if (arr[i] != (i + 1)) {
				swap(arr, i);
				counts++;
			} else {
				i++;
			}
		}
		return counts;
	}

	private static void swap(int[] arr, int j) {
		int temp = arr[j];
		arr[j] = arr[arr[j] - 1];
		arr[temp - 1] = temp;
	}

}
