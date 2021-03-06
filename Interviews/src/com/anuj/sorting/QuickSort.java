package com.anuj.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		System.out.println("Before Sorting: " + Arrays.toString(a));
		quickSort(a, 0, a.length - 1);
		System.out.println("After Sorting: " + Arrays.toString(a));
		scanner.close();
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivotItem = arr[end];
		int left = start, right = end;

		while (left < right) {
			while (left <= end && arr[left] < pivotItem) {
				left++;
			}
			while (right >= 0 && arr[right] >= pivotItem) {
				right--;
			}
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}

		arr[end] = arr[left];
		arr[left] = pivotItem;

		return left;
	}
}
