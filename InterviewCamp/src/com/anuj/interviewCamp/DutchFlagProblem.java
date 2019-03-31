package com.anuj.interviewCamp;

import java.util.Arrays;

public class DutchFlagProblem {

	public static void main(String[] args) {
		int[] arr = null/*new int[]{1,2,3,4,2,0}*/;
		arrangeAsDutchFlag(arr, 2);
		System.out.println(Arrays.toString(arr));
	}

	public static void arrangeAsDutchFlag(int[] input, int refer) {
		if (input == null || input.length <= 1) {
			return ;
		}
		int l = -1, m = -1, r = input.length;

		while (m + 1 < r) {
			if (input[m + 1] > refer) {
				swap(input, r - 1, m + 1);
				r--;
			} else if (input[m + 1] == refer) {
				m++;
			} else {
				swap(input, m + 1, l + 1);
				l++;
				m++;

			}
		}
	}

	public static void swap(int[] arr, int p1, int p2) {
		int temp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = temp;
	}
}
