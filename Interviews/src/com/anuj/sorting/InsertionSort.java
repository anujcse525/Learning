package com.anuj.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		insertionSort(a);
		System.out.println(Arrays.toString(a));
		scanner.close();
	}

	private static void insertionSort(int[] arr) {
		for (int i = 2; i < arr.length; i++) {
			int min = arr[i], j = i;
			while (arr[j - 1] > min && j >= 1) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = min;
		}
	}

}
