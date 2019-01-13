package com.anuj.algos;

public class Searching {

	public static void main(String[] args) {
		int[] arr = { 3, 12, 23, 34, 45, 56, 67, 78, 89 };
		System.out.println(linearSearch(arr, 12));
		System.out.println(binarySearch(arr, 0, arr.length, 67));
	}

	public static int linearSearch(int[] arr, int num) {
		if (arr.length == 0) {
			return -1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return i + 1;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] arr, int begin, int end, int num) {
		if (arr.length == 0 || begin > end) {
			return -1;
		}

		int mid = (begin + end) / 2;

		if (arr[mid] == num) {
			return mid + 1;
		}
		if (arr[mid] > num) {
			return binarySearch(arr, begin, mid, num);
		} else {
			return binarySearch(arr, mid, end, num);
		}
	}

}
