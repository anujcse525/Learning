package com.anuj.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	static void countSwaps(int[] a) {
		int unsortedLength = a.length - 1;
		boolean isSorted = false;
		int count = 0;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < unsortedLength; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					count++;
					isSorted = false;
				}
			}
			unsortedLength--;
		}
		System.out.println("Array is sorted in " + count + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[a.length - 1]);

	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		countSwaps(a);
		System.out.println(Arrays.toString(a));
		scanner.close();
	}

}
