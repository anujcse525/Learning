package com.anuj.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class HourGlass {

	// Complete the hourglassSum function below.

	static int hourglassSum(int[][] arr) {

		int maxSum = Integer.MIN_VALUE;

		int currSum = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				currSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][1 + j] + arr[i + 2][j]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
				if (maxSum < currSum)
					maxSum = currSum;
			}
		}

		System.out.println("Max Sum : " + maxSum);
		return maxSum;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}
		System.out.println("Length " + arr.length);
		int result = hourglassSum(arr);

		System.out.println(result);

		scanner.close();
	}
}
