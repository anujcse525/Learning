package com.anuj.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		selectionSort(a);
		System.out.println(Arrays.toString(a));
		scanner.close();
	}

	private static void selectionSort(int[] a) {
		int temp, count = 0;
		boolean swapNeeded = false;
		for (int i = 0; i < a.length; i++) {
			int min = i;
			swapNeeded = false;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
					swapNeeded = true;
				}
			}
			if (swapNeeded) {
				count++;
				temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}

		}
		System.out.println(count);

	}

}
