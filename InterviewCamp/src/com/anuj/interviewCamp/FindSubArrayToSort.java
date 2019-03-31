package com.anuj.interviewCamp;

/*
 * Given an array of integers, find the shortest subarray, that if sorted, results in the entire array being sorted.
 * [1,2,4,5,3,5,6,7,9] --> [4,5,3] 
 * - If you sort from indices 2 to 4, 
 * the entire array is sorted.[1,3,5,2,6,4,7,8,9] --> [3,5,2,6,4] 
 * - indices 1 to 5
 * Questions to Clarify:
 * Q. How to return the result?
 * A. Return the result as a pair of indices.
 * 
 * Solution:Start from 0. Find the first dip in value, 
 * call that i.[1,3,5,2,6,4,7,8,9] --> First dip starts at index 
 * 2.Start from end. Find the first bump in value, call that j.
 * [1,3,5,2,6,4,7,8,9] --> First bump starts at index 5.
 * We now know that the subarray [i,j] is causing the array to be unsorted. 
 * But simply sortingthis subarray will not sort the array. 
 * After all, sorting [5,2,6,4] will not do the trickbecause there is a 3 before it. 
 * We need to expand this subarray. 
 * Let's find the min of subarray [i,j].In this case, the min is 2. 
 * In order for the entire array to be sorted, we will have to expand subarray [i,j] to include all numbers greater than 2. 
 * So we expand from {5,2,6,4} to {3,5,2,6,4}.
 * We do the same for max. 
 * We don't need to expand for max in this case, so that subarray is the answer.
 * Pseudocode:
 * loop start = 0 to a.length - 1     
 * 		find first dip -> i
 * loop end = a.length - 1 to 0
 *      find first bump -> j
 * if no dip or bump, already sorted, return
 * find max and min in subarray [i,j]
 * expand i left, until you find an element less than min
 * expand j right, until you find an element greater than max
 * return i,j
 * Test Cases:
 * Edge Cases: empty array, null array
 * Base Case: one element, 2 elements (sorted and unsorted)
 * Regular Case: array already sorted, sorted portion at beginning/end etc.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FindSubArrayToSort {

	public static void main(String[] args) {
		System.out.println(findSubArrayIndex(new int[] { 0, 2, 5, 3, 18, 6, 9, 10 }));
	}

	public static String findSubArrayIndex(int[] input) {

		if (input == null || input.length <= 1) {
			return null;
		}
		int i, j;

		for (i = 0; i < input.length - 1; i++) {
			if (input[i + 1] < input[i]) {
				break;
			}
		}

		for (j = input.length - 1; j > 0; j--) {
			if (input[j] < input[j - 1]) {
				break;
			}
		}

		if (i >= input.length - 1 || j <= 0) {
			return null;
		}

		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

		for (int k = i; k <= j; k++) {
			if (input[k] > max) {
				max = input[k];
			}
			if (input[k] < min) {
				min = input[k];
			}
		}

		while (i > 0 && input[i] > min) {
			i--;
		}

		while (j < input.length - 1 && input[j] < max) {
			j++;
		}
		return i + " " + j;
	}
}
