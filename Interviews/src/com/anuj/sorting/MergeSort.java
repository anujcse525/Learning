package com.anuj.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		mergeSort(a);
		System.out.println(Arrays.toString(a));
		scanner.close();
	}

	public static void mergeSort(int[] arr) {
		int length = arr.length;
		if (length == 1) {
			return;
		}
		int m = (0 + length) / 2;
		int[] left = new int[m];
		int[] right = new int[length - m];

		for (int i = 0; i < m; i++) {
			left[i] = arr[i];
		}
		for (int j = m; j < length; j++) {
			right[j - m] = arr[j];
		}
		mergeSort(left);
		mergeSort(right);

		mergeSortedArr(arr, left, right);

	}

	public static void mergeSortedArr(int[] arr, int[] left, int[] right) {
		if (arr == null || arr.length == 0) {
			return;
		}

		int leftLength = left.length, rightLength = right.length, i = 0, j = 0, k = 0;

		while (i < leftLength && j < rightLength) {
			if (left[i] < right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}

		}

		if (i < leftLength) {
			while (i < leftLength) {
				arr[k++] = left[i++];
			}
		}

		if (j < rightLength) {
			while (j < rightLength) {
				arr[k++] = right[j++];
			}
		}

	}
}
